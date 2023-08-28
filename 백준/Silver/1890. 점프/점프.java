import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int n;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());

		int[][] board = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++)
				board[i][j] = Integer.parseInt(st.nextToken());
		}
		
		long[][] D = new long[n][n];
		D[0][0] = 1;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(board[i][j] == 0) continue;
				int move = board[i][j];
				if(isIn(i + move, j))
					D[i + move][j] += D[i][j];
				
				if(isIn(i, j + move))
					D[i][j + move] += D[i][j];
			}
		}
		
		System.out.println(D[n - 1][n - 1]);
	}

	public static boolean isIn(int r, int c) {
		if(r >= n || c >= n)
			return false;
		return true;
	}
}