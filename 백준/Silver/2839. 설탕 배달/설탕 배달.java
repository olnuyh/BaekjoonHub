import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		int[] D = new int[n + 1];
		
		for(int i = 0; i <= n; i++)
			D[i] = -1;
		
		D[3] = 1;
		
		if(n >= 5)
			D[5] = 1;
		
		for(int i = 6; i <= n; i++) {
			int a = Integer.MAX_VALUE;
			int b = Integer.MAX_VALUE;
			
			if(D[i - 3] != -1)
				a = D[i - 3] + 1;
			if(D[i - 5] != -1)
				b = D[i - 5] + 1;

			if(a == Integer.MAX_VALUE && b == Integer.MAX_VALUE) continue;
			
			D[i] = Math.min(a, b);
		}
		
		System.out.println(D[n]);
	}

}