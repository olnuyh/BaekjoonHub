import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n, m;
	static int[] weight;
	static int maxWeight;
	
	static void selectSnacks(int cnt, int start, int sum) {
		if(cnt == 2) {
			if(sum <= m)
				maxWeight = Math.max(maxWeight, sum);
			return;
		}
		
		for(int i = start; i < n; i++)
			selectSnacks(cnt + 1, i + 1, sum + weight[i]);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			weight = new int[n];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++)
				weight[i] = Integer.parseInt(st.nextToken());
			
			maxWeight = -1;
			selectSnacks(0, 0, 0);
			
			sb.append("#").append(tc).append(" ").append(maxWeight).append("\n");
		}

		System.out.println(sb);
	}

}