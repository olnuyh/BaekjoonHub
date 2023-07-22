import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int n;
	public static int[] nums;
	public static char[] operators;
	public static boolean[] visited;
	
	public static int min = Integer.MAX_VALUE;
	public static int max = Integer.MIN_VALUE;
	
	public static int calc(char operator, int n1, int n2) {
		int ans = 0;
		switch(operator) {
			case '+':
				ans = n1 + n2;
				break;
			case '-':
				ans = n1 - n2;
				break;
			case '*':
				ans = n1 * n2;
				break;
			case '/':
				ans = n1 / n2;
				break;
		}
		
		return ans;
	}
	
	public static void bruteForce(int cnt, int ans) {
		if(cnt == n - 1){
			max = Math.max(max, ans);
			min = Math.min(min, ans);
			return;
		}
		
		for(int i = 0; i < n - 1; i++) {
			if(!visited[i]) {
				visited[i] = true;
				bruteForce(cnt + 1, calc(operators[i], ans, nums[cnt + 1]));
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		nums = new int[n];
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++)
			nums[i] = Integer.parseInt(stk.nextToken());

		String oper = "+-*/";
		
		operators = new char[n - 1];
		int k = 0;
		stk = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++){
			int temp = Integer.parseInt(stk.nextToken());
			for(int j = 0; j < temp; j++)
				operators[k++] = oper.charAt(i);
		}
		
		visited = new boolean[n - 1];
		char[] newOperators = new char[n - 1];
		bruteForce(0, nums[0]);
		
		System.out.println(max);
		System.out.println(min);
	}
}