import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static int[][] deltas = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			int[][] snail = new int[n][n];
			
			int r = 0;
			int c = -1;
			int d = 0;
			
			int num = 1;
			
			while(num <= n * n) {
				int nr = r + deltas[d][0];
				int nc = c + deltas[d][1];
				
				if(nr >= 0 && nr < n && nc >= 0 && nc < n && snail[nr][nc] == 0) {
					snail[nr][nc] = num++;
					
					r = nr;
					c = nc;
					
				}else {
					nr -= deltas[d][0];
					nc -= deltas[d][1];
					
					d = (d + 1) % 4;
				}
			}
			
			sb.append("#").append(tc).append("\n");
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++)
					sb.append(snail[i][j]).append(" ");
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

}