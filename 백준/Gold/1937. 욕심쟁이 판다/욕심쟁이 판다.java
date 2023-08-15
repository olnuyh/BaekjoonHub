import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int n;
	public static int[][] forest;
	public static int[][] visited;
	public static int[] dr = {-1, 1, 0, 0};
	public static int[] dc = {0, 0, -1, 1};

	public static int dfs(int r, int c) {
		int cnt = 0;
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr < 0 || nr >= n || nc < 0 || nc >= n)
				continue;
			
			if(forest[nr][nc] > forest[r][c]) {
				if(visited[nr][nc] == 0)
					cnt = Math.max(cnt, dfs(nr, nc));
				else
					cnt = Math.max(cnt, visited[nr][nc]);
			}
		}
		
		visited[r][c] = cnt + 1;
		return visited[r][c];
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		forest = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++)
				forest[i][j] = Integer.parseInt(st.nextToken());
		}
		
		visited = new int[n][n];
		int answer = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(visited[i][j] == 0) {
					dfs(i, j);
				}
				
				if(answer < visited[i][j])
					answer = visited[i][j];
			}
		}
		
		System.out.println(answer);
	}

}