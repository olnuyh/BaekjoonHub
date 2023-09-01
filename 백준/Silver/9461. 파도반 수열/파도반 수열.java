import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			
			if(N == 1 || N == 2) {
				sb.append("1\n");
				continue;
			}

			long[] D = new long[N + 1];
			D[0] = 0;
			D[1] = D[2] = 1;
			
			for(int j = 3; j <= N; j++)
				D[j] = D[j - 3] + D[j - 2];
			
			sb.append(D[N]).append("\n");
		}
		
		System.out.println(sb);
	}

}