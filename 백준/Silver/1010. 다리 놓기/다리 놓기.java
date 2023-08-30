import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[][] D;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			D = new int[m + 1][m + 1];
			sb.append(calc(m, n)).append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static int calc(int n, int r) {
		if(r == 0 || r == n)
			D[n][r] = 1;
		if(D[n][r] == 0) D[n][r] = calc(n - 1, r - 1) + calc(n - 1, r);
		return D[n][r];
	}
	
}