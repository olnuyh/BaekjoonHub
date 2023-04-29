import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] nums = new int[n];
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++)
		{
			nums[i] = Integer.parseInt(stk.nextToken());
		}
		
		int[] result = new int[n];
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < n; i++)
		{			
			while(!stack.empty() && nums[stack.peek()] < nums[i]) {
				result[stack.pop()] = nums[i];
			}
			
			stack.push(i);
		}
		
		while(!stack.empty()) {
			result[stack.pop()] = -1;
		}
		
		for(int i = 0; i < n; i++)
			bw.write(result[i] + " ");
		
		bw.write("\n");
		bw.flush();
		bw.close();
	}
}