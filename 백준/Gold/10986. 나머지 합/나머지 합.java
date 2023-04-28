import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		
		stk = new StringTokenizer(br.readLine());
		
		long[] S = new long[n + 1];
		long answer = 0;
		long[] C = new long[m];
		
		for(int i = 1; i <= n; i++)
		{
			S[i] = (S[i - 1] + Integer.parseInt(stk.nextToken())) % m;
			if(S[i] == 0)
				answer += 1;
			C[(int)S[i]] += 1;
		}
		
		for(int i = 0; i < m; i++) {
			if(C[i] > 1)
				answer += C[i] * (C[i] - 1) / 2;
		}
		
		System.out.println(answer);
	}
}