import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] num = new int[N];
		String str = br.readLine();
		for(int i = 0; i < N; i++)
			num[i] = str.charAt(i) - '0';
		
		Stack<Integer> stack = new Stack<>();
		int cnt = 0;
		
		for(int i = 0; i < N; i++) {
			if(stack.isEmpty() || num[stack.peek()] >= num[i])
				stack.push(i);
			else {
				while(!stack.isEmpty() && cnt < K && num[stack.peek()] < num[i]) {
					cnt++;
					stack.pop();
				}
				stack.push(i);
			}
		}
		
		while(cnt < K) {
			stack.pop();
			cnt++;
		}
		
		while(!stack.isEmpty())
			sb.append(num[stack.pop()]);
		
		System.out.println(sb.reverse());
	}

}