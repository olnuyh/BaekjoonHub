import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc++) {
			Stack<Character> stack = new Stack<>();
			
			String str = br.readLine();
			boolean isVPS = true;
			
			for(int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == '(')
					stack.push('(');
				else {
					if(stack.isEmpty() || stack.peek() == ')') {
						isVPS = false;
						break;
					}else
						stack.pop();
				}
			}
			
			if(isVPS && stack.isEmpty())
				sb.append("YES\n");
			else
				sb.append("NO\n");
		}
		
		System.out.println(sb);
	}

}