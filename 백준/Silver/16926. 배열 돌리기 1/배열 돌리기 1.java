import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[][] origin;
	public static int N, M;
	public static int[] dr = {0, 1, 0, -1};
	public static int[] dc = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		origin = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++)
				origin[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < R; i++)
			rotate();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++)
				System.out.print(origin[i][j] + " ");
			System.out.println();
		}
	}

	public static void rotate() {
		int cnt = Math.min(N, M) / 2;
		for(int i = 0; i < cnt; i++) {
			int tmp = origin[i][i];
			
			int r = i;
			int c = i;
			
			int d = 0;
			while(d < 4) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr < i || nr >= N - i || nc < i || nc >= M - i) {
					d++;
					continue;
				}
				
				origin[r][c] = origin[nr][nc];
				r = nr;
				c = nc;
			}
			
			origin[i + 1][i] = tmp;
		}
	}
}