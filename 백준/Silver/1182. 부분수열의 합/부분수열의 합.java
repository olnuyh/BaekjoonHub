import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int count;
	public static int S;
	public static int[] nums;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		count = 0;
		
		nums = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0, N, 0);
		
		if (S == 0) {
			count--;
		}
		
		System.out.println(count);
	}
	
	public static void dfs (int depth, int k, int sum) {
		if (depth == k) {
			if (sum == S) {
				count++;
			}
			
			return;
		}
		
		dfs(depth + 1, k, sum);
		dfs(depth + 1, k, sum + nums[depth]);
	}

}