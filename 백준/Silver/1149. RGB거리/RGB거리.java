import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] cost = new int[n][3];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++)
				cost[i][j] = Integer.parseInt(st.nextToken());
		}

		int[][] D = new int[n + 1][3];
		for(int i = 0; i <= n; i++)
			Arrays.fill(D[i], Integer.MAX_VALUE);
		
		for(int i = 0; i < 3; i++)
			D[0][i] = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < 3; j++) {
				for(int k = 0; k < 3; k++) {
					if(j == k) continue;
					
					D[i + 1][k] = Math.min(D[i + 1][k], D[i][j] + cost[i][j]);
				}
			}
		}
		
		int answer = Integer.MAX_VALUE;
		for(int i = 0; i < 3; i++)
			answer = Math.min(answer, D[n][i]);
		
		System.out.println(answer);
	}

}