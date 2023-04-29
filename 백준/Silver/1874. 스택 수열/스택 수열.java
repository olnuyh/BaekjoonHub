import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
	
		int num = 1;
		Stack<Integer> stack = new Stack<>();
		boolean isOk = true;
		
		for(int i = 0; i < n; i++) {
			int find = Integer.parseInt(br.readLine());
			while(num <= find)
			{
				sb.append("+\n");
				stack.push(num);
				num++;
			}
			if(stack.pop() == find)
				sb.append("-\n");
			else {
				isOk = false;
			}
		}
		
		if(isOk) {
			System.out.println(sb.toString());
		}
		else
			System.out.println("NO");
	}
}