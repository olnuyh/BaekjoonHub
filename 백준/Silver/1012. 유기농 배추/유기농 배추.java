import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static int m, n;
	static int[][] farm;
	
	public static void dfs(int r, int c) {
		farm[r][c] = 0;
		
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
			
			if(farm[nr][nc] == 1)
				dfs(nr, nc);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			farm = new int[n][m];
			
			for(int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				
				farm[r][c] = 1;
			}
			
			int cnt = 0;
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(farm[i][j] == 1) {
						dfs(i, j);
						cnt++;
					}
				}
			}
			
			sb.append(cnt).append("\n");
		}
		
		System.out.println(sb);
	}

}