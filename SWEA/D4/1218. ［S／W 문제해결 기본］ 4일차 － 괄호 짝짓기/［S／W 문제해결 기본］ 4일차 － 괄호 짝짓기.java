import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String start = "([{<";
		String end = ")]}>";
		
		for(int t = 1; t <= 10; t++) {
			int n = Integer.parseInt(br.readLine());
			
			String str = br.readLine();
			
			Stack<Character> stack = new Stack<>();
			
			int isPossible = 1;
			
			for(int i = 0; i < n; i++) {
				char c = str.charAt(i);
				
				if(start.indexOf(c) >= 0) {
					stack.push(c);
				}else {
					char top = end.charAt(start.indexOf(stack.peek()));
					if(top == c)
						stack.pop();
					else {
						isPossible = 0;
						break;
					}
				}
			}
			
			sb.append("#").append(t).append(" ").append(isPossible).append("\n");
		}
		
		System.out.println(sb);
	}

}