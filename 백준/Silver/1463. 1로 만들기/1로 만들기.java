import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		int[] D = new int[n + 1];
		Arrays.fill(D, Integer.MAX_VALUE);
		D[n] = 0;
		
		for(int i = n - 1; i >= 1; i--) {
			if(i * 3 <= n)
				D[i] = Math.min(D[i], D[i * 3] + 1);
			
			if(i * 2 <= n)
				D[i] = Math.min(D[i], D[i * 2] + 1);
			
			D[i] = Math.min(D[i], D[i + 1] + 1);
		}
		
		System.out.println(D[1]);
	}

}