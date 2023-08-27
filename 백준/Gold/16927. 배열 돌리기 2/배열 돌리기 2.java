import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[][] arr;
	public static int n, m, r;
	
	public static int[] dr = {0, 1, 0, -1};
	public static int[] dc = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int nowN = n;
		int nowM = m;
		
		for(int i = 0; i < Math.min(n, m) / 2; i++) {
			
			rotation(i, 2 * (nowN + nowM - 2));
			nowN -= 2;
			nowM -= 2;
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++)
				sb.append(arr[i][j] + " ");
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

	public static void rotation(int start, int len) {
		int k = r % len;
		
		for(int i = 0; i < k; i++) {
			int temp = arr[start][start];
			int curR = start;
			int curC = start;
			int d = 0;
			
			while(d < 4) {
				int nr = curR + dr[d];
				int nc = curC + dc[d];
				
				if(nr == start && nc == start)
					break;
				
				if(nr < start || nr >= n - start || nc < start || nc >= m - start) {
					d++;
					continue;
				}
				
				arr[curR][curC] = arr[nr][nc];
				curR = nr;
				curC = nc;
			}
			
			arr[start + 1][start] = temp;
		}
	}
}