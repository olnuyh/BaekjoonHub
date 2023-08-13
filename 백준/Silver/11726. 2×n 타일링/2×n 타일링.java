import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		int[] D = new int[n + 1];
		
		D[0] = 1;
		D[1] = 1;
	
		for(int i = 2; i <= n; i++) 
			D[i] = (D[i - 2] + D[i - 1]) % 10007;
		
		System.out.println(D[n]);
	}

}