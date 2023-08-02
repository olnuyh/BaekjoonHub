import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] num = new int[n + 1];
		for(int i = 1; i <= n; i++)
			num[i] = Integer.parseInt(st.nextToken());
		
		int[] S = new int[n + 1];

		for(int i = 1; i <= n; i++)
			S[i] = S[i - 1] + num[i];
		
		for(int t = 0; t < m; t++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			
			sb.append(S[j] - S[i - 1]).append("\n");
		}
		
		System.out.println(sb);
	}
}