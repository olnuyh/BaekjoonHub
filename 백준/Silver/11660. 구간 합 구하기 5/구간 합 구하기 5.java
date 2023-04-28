import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		
		long[][] S = new long[n + 1][n + 1];
		for(int i = 1; i <= n; i++)
		{
			stk = new StringTokenizer(br.readLine());
			for(int j = 1; j <= n; j++)
			{
				S[i][j] = Integer.parseInt(stk.nextToken()) + S[i - 1][j] + S[i][j - 1] - S[i - 1][j - 1];
			}
		}
		
		for(int i = 0; i < m; i++)
		{
			stk = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(stk.nextToken());
			int y1 = Integer.parseInt(stk.nextToken());
			int x2 = Integer.parseInt(stk.nextToken());
			int y2 = Integer.parseInt(stk.nextToken());
			
			System.out.println(S[x2][y2] - S[x2][y1 - 1] - S[x1 - 1][y2] + S[x1 - 1][y1 - 1]);		
		}	
	}
}