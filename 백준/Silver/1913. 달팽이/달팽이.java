import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static int[][] deltas = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][N];
		
		int num = N * N;
		
		int r = -1;
		int c = 0;
		int d = 0;
		
		while (num > 0) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			
			if (isIn(nr, nc) && arr[nr][nc] == 0) {
				arr[nr][nc] = num--;
				r = nr;
				c = nc;
			} else {
				d = (d + 1) % 4;
			}
		}
		
		int[] pos = new int[2];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(arr[i][j]).append(" ");
				
				if (arr[i][j] == M) {
					pos[0] = i + 1;
					pos[1] = j + 1;
				}
			}
			sb.append("\n");
		}
		
		sb.append(pos[0]).append(" ").append(pos[1]);
		
		System.out.println(sb);
		
	}
	
	public static boolean isIn (int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}