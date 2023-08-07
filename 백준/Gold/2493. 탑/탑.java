import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] height = new int[n];
		
		for(int i = 0; i < n; i++)
			height[i] = Integer.parseInt(st.nextToken());
		
		Stack<Integer> stack = new Stack<>();
		
		int[] reception = new int[n];
		
		for(int i = 0; i < n; i++) {
			while(!stack.isEmpty() && height[stack.peek()] < height[i])
				stack.pop();
			
			if(!stack.isEmpty())
				reception[i] = stack.peek() + 1;

			stack.push(i);
		}

		for(int i = 0; i < n; i++)
			System.out.print(reception[i] + " ");
	}

}