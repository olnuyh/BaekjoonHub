import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int n, m;
	public static int[] card;
	public static int maxSum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		card = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			card[i] = Integer.parseInt(st.nextToken());
		
		maxSum = 0;
		comb(0, 0, 0);
		
		System.out.println(maxSum);
	}

	public static void comb(int cnt, int start, int sum) {
		if(cnt == 3) {
			maxSum = Math.max(maxSum, sum);
			return;
		}
		
		for(int i = start; i < n; i++) {
			if(sum + card[i] <= m)
				comb(cnt + 1, i + 1, sum + card[i]);
		}
	}
}