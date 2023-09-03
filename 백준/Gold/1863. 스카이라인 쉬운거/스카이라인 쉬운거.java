import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			int y = Integer.parseInt(st.nextToken());
			
			while(!stack.isEmpty() && stack.peek() >= y) {
				if(stack.peek() > y)
					cnt++;
				stack.pop();
			}
			
			stack.push(y);
		}
		
		while(!stack.isEmpty()) {
			if(stack.pop() > 0)
				cnt++;
		}
		
		System.out.println(cnt);
	}

}