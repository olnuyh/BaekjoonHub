import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int n, m;
	public static StringBuilder sb = new StringBuilder();
	
	public static void comb(int nthChoice, int startIndex, int[] choosed) {
		if(nthChoice == m) {
			for(int i = 0; i < m; i++)
				sb.append(choosed[i] + " ");
			sb.append("\n");
			return;
		}
			
		for(int i = startIndex; i <= n; i++) {
			choosed[nthChoice] = i;
			comb(nthChoice + 1, i + 1, choosed);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		comb(0, 1, new int[m]);
		System.out.println(sb);
	}

}