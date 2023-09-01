import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		int[] D = new int[11];
		D[1] = 1;
		D[2] = 2;
		D[3] = 4;
		
		for(int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			for(int j = 4; j <= N; j++)
				D[j] = D[j - 3] + D[j - 2] + D[j - 1];
			
			sb.append(D[N]).append("\n");
		}
		
		System.out.println(sb);
	}

}