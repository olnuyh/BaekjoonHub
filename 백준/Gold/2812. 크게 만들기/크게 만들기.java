import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
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
		
		Deque<Integer> stack = new ArrayDeque<>();
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
			sb.append(num[stack.pollLast()]);
		
		System.out.println(sb);
	}

}