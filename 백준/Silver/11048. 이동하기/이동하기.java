import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[] dr = {0, -1, -1};
	public static int[] dc = {-1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] candy = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++)
				candy[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int[][] D = new int[n + 1][m + 1];
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				for(int k = 0; k < 3; k++) {
					int nr = i + dr[k];
					int nc = j + dc[k];
					
					if(nr < 0 || nc < 0) continue;
					
					D[i][j] = Math.max(D[i][j], D[nr][nc] + candy[i - 1][j - 1]);
				}
			}
		}
		
		System.out.println(D[n][m]);
	}

}