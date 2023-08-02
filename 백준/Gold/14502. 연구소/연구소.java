import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int area;
	static int maxSafeArea;
	static int virus;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] map;
	static boolean[][] visited;
	
	public static void buildWall(int r) {
		if(r == 3) {
			virus = 0;
			visited = new boolean[n][m];
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(!visited[i][j] && map[i][j] == 2) 
						spreadVirus(i, j);
				}
			}
			
			maxSafeArea = Math.max(maxSafeArea, area - virus);

			return;
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					buildWall(r + 1);
					map[i][j] = 0;
				}
			}
		}
	}
	
	public static void spreadVirus(int r, int c) {
		visited[r][c] = true;
		virus++;
		
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
			
			if(!visited[nr][nc] && map[nr][nc] == 0)
				spreadVirus(nr, nc);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		
		area = n * m - 3;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1)
					area--;
			}
		}
		
		maxSafeArea = Integer.MIN_VALUE;
		buildWall(0);
		
		System.out.println(maxSafeArea);
	}

}