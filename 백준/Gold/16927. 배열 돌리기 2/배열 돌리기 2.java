import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[][] arr;
	public static int n, m;
	
	public static int[] dr = {0, 1, 0, -1};
	public static int[] dc = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		rotation(r);
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++)
				sb.append(arr[i][j] + " ");
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

	public static void rotation(int r) {
		int startR = 0;
		int startC = 0;
		
		int endR = n - 1;
		int endC = m - 1;
		
		while(startR < endR && startC < endC) {
			int lap = 2 * (endC - startC + endR - startR);
			int k = r % (2 * lap);
			
			for(int i = 0; i < k; i++) {
				int temp = arr[startR][startC];
				int curR = startR;
				int curC = startC;
				
				int d = 0;
				while(true) {
					int nr = curR + dr[d];
					int nc = curC + dc[d];
					
					if(nr < startR || nr > endR || nc < startC || nc > endC) {
						d += 1;
						
						if(d == 4)
							break;
						
						nr = curR + dr[d];
						nc = curC + dc[d];
					}
					
					arr[curR][curC] = arr[nr][nc];
					curR = nr;
					curC = nc;
				}
				
				arr[startR + 1][startC] = temp;
				
			}
			
			startR++;
			startC++;
			endR--;
			endC--;
		}
	}
}