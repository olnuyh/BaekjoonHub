import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int[] dr = {0, 1, 1};
	public static int[] dc = {1, 0, 1};
	
	public static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		int[][] house = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++)
				house[i][j] = Integer.parseInt(st.nextToken());
		}
		
		long[][][] D = new long[3][N][N]; // 0: 가로, 1: 세로, 2: 대각선
		D[0][0][1] = 1;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < 3; k++) {
					if(D[k][i][j] != 0) {						
						long val = D[k][i][j];
						
						switch(k) {
							case 0: // 가로일 때
								if(isIn(i, j + 1) && house[i][j + 1] == 0)
									D[0][i][j + 1] += val;
								
								boolean check = true;
								if(isIn(i + 1, j + 1)) {
									for(int d = 0; d < 3; d++) {
										int nr = i + dr[d];
										int nc = j + dc[d];
										
										if(house[nr][nc] != 0) {
											check = false;
											break;
										}
									}
								}else
									check = false;
								
								if(check)
									D[2][i + 1][j + 1] += val;
								
								break;
							case 1: // 세로일 때
								if(isIn(i + 1, j) && house[i + 1][j] == 0)
									D[1][i + 1][j] += val;
								
								check = true;
								if(isIn(i + 1, j + 1)) {
									for(int d = 0; d < 3; d++) {
										int nr = i + dr[d];
										int nc = j + dc[d];
										
										if(house[nr][nc] != 0) {
											check = false;
											break;
										}
									}
								}else
									check = false;
								
								if(check)
									D[2][i + 1][j + 1] += val;
								
								break;
							case 2: // 대각선일 때
								if(isIn(i, j + 1) && house[i][j + 1] == 0)
									D[0][i][j + 1] += val;
								
								if(isIn(i + 1, j) && house[i + 1][j] == 0)
									D[1][i + 1][j] += val;
								
								check = true;
								if(isIn(i + 1, j + 1)) {
									for(int d = 0; d < 3; d++) {
										int nr = i + dr[d];
										int nc = j + dc[d];
										
										if(house[nr][nc] != 0) {
											check = false;
											break;
										}
									}
								}else
									check = false;
								
								if(check)
									D[2][i + 1][j + 1] += val;
								break;
						}
					}
				}
			}
		}
		
		
		long answer = 0;
		
		for(int i = 0; i < 3; i++)
			answer += D[i][N - 1][N - 1];
		
		System.out.println(answer);	
	}
	
	public static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

}