import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		int[][] D = new int[15][15];
		
		for(int i = 1; i <= 14; i++)
			D[0][i] = i;
		
		for(int i = 1; i <= 14; i++) {
			for(int j = 1; j <= 14; j++)
				D[i][j] = D[i - 1][j] + D[i][j - 1];
		}
		
		for(int tc = 1; tc <= t; tc++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			sb.append(D[k][n]).append("\n");
		}
		
		System.out.println(sb);
	}

}