import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static StringBuilder sb = new StringBuilder();
	public static int n, x, m;
	public static int[][] question;
	
	public static int max;
	public static int[] answer;
	
	public static void permutation(int r, int[] output, int[] sum) {
		if(r == n) {
			for(int i = 0; i < question.length; i++) {
				if(question[i][2] != (sum[question[i][1]] - sum[question[i][0] - 1]))
					return;
			}
			
			if(max < sum[n]) {
				max = sum[n];
				
				for(int i = 0; i < n; i++)
					answer[i] = output[i];
			}
			
			return;
		}
		
		for(int i = 0; i <= x; i++) {
			output[r] = i;
			sum[r + 1] = sum[r] + i;
			permutation(r + 1, output, sum);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			question = new int[m][3];
			
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				question[i][0] = Integer.parseInt(st.nextToken());
				question[i][1] = Integer.parseInt(st.nextToken());
				question[i][2] = Integer.parseInt(st.nextToken());
			}
			
			max = Integer.MIN_VALUE;
			answer = new int[n];
			
			permutation(0, new int[n], new int[n + 1]);
			
			sb.append("#").append(tc).append(" ");
			
			if(max == Integer.MIN_VALUE)
				sb.append("-1\n");
			else {
				for(int i = 0; i < n; i++)
					sb.append(answer[i] + " ");
				sb.append("\n");
			}
		}
		
		System.out.println(sb);
	}

}