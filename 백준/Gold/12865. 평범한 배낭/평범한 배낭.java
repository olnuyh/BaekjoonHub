import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] product = new int[N + 1][2];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int W = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			
			product[i][0] = W;
			product[i][1] = V;
		}
		
		int[] D = new int[K + 1];
		for(int i = 1; i <= N; i++) {
			for(int j = K; j >= product[i][0]; j--)
				D[j] = Math.max(D[j], product[i][1] + D[j - product[i][0]]);
		}
		
		System.out.println(D[K]);
	}

}