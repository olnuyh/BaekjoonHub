import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		
		long[] S = new long[n + 1];
		
		stk = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++)
		{
			S[i] = S[i - 1] + Integer.parseInt(stk.nextToken());
		}
		
		for(int k = 0; k < m; k++)
		{
			stk = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(stk.nextToken());
			int j = Integer.parseInt(stk.nextToken());
			
			System.out.println(S[j] - S[i - 1]);
		}
	}
}