import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] height = new int[n];
		
		for(int i = 0; i < n; i++)
			height[i] = Integer.parseInt(st.nextToken());
		
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		
		int[] reception = new int[n];
		
		for(int i = n - 1; i >= 0; i--) {
			while(!stack.isEmpty() && height[stack.peek()] <= height[i])
				reception[stack.pop()] = i + 1;

			stack.push(i);
		}

		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < n; i++)
			sb.append(reception[i] + " ");
		
		System.out.println(sb);
	}

}