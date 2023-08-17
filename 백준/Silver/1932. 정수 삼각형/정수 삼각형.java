import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] triangle = new int[n][n];
		int[][] dp = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j <= i; j++)
				triangle[i][j] = Integer.parseInt(st.nextToken());
		}
		
		dp[0][0] = triangle[0][0];
		
		for(int i = 1; i < n; i++)
			dp[i][0] = dp[i - 1][0] + triangle[i][0];
		
		for(int i = 1; i < n; i++) {
			for(int j = 1; j <= i; j++)
				dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
		}
		
		int ans = 0;
		for(int i = 0; i < n; i++)
			ans = Math.max(ans, dp[n - 1][i]);
		
		System.out.println(ans);
	}

}