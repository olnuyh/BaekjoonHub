import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] wire = new int[501];

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			wire[start] = Integer.parseInt(st.nextToken());
		}
		
		int[] D = new int[501];
		int maxConnected = 1;
		for(int i = 1; i <= 500; i++) {
			if(wire[i] == 0) continue;
			D[i] = 1;
			for(int j = 1; j < i; j++) {
				if(wire[j] < wire[i])
					D[i] = Math.max(D[i], D[j] + 1);
			}
			
			maxConnected = Math.max(maxConnected, D[i]);
		}
		
		System.out.println(N - maxConnected);
	}

}