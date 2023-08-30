import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] coin = new int[n];
		
		for(int i = 0; i < n; i++)
			coin[i] = Integer.parseInt(br.readLine());
			
		int[] D = new int[k + 1];
		Arrays.fill(D, Integer.MAX_VALUE);
		
		for(int i = 0; i < n; i++) {
			if(coin[i] <= k)
				D[coin[i]] = 1;
		}
		
		for(int i = 1; i <= k; i++) {
			for(int j = 0; j < n; j++) {
				if(i >= coin[j] && D[i - coin[j]] != Integer.MAX_VALUE)
					D[i] = Math.min(D[i], D[i - coin[j]] + 1);
			}
		}
		
		if(D[k] == Integer.MAX_VALUE)
			D[k] = -1;
		
		System.out.println(D[k]);
	}

}