import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int[] dr = {-1, 1, 0, 0};
	public static int[] dc = {0, 0, -1, 1};
	
	public static int n, m;
	public static char[][] campus;
	public static boolean[][] visited;
	
	public static int bfs(int startR, int startC) {
		Queue<int []> q = new ArrayDeque<>();
		
		q.offer(new int[] {startR, startC});
		visited[startR][startC] = true;
		
		int cnt = 0;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nr = now[0] + dr[i];
				int nc = now[1] + dc[i];
				
				if(nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
				
				if(!visited[nr][nc] && campus[nr][nc] != 'X') {
					visited[nr][nc] = true;
					q.offer(new int[] {nr, nc});
					
					if(campus[nr][nc] == 'P')
						cnt++;
				}
			}
		}
		
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		campus = new char[n][m];
		
		int[] doyeon = new int[2];
		
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			for(int j = 0; j < m; j++) {
				campus[i][j] = str.charAt(j);
				
				if(campus[i][j] == 'I') {
					doyeon[0] = i;
					doyeon[1] = j;
				}
			}
		}
		
		visited = new boolean[n][m];
		
		int result = bfs(doyeon[0], doyeon[1]);
		
		if(result == 0)
			System.out.println("TT");
		else
			System.out.println(result);
	}

}