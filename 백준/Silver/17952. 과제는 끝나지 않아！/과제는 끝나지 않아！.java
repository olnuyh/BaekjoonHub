import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Task{
	int score, time;
	
	public Task(int score, int time) { 
		this.score = score; 
		this.time = time;
	}
}

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st; 
		
		int n = Integer.parseInt(br.readLine()); 
		
		Stack<Task> stack = new Stack<>();
		int result = 0;
		
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken()); 
			
			if(c == 0) {
				if(stack.isEmpty()) continue;
				
				Task task = stack.pop();
				if(task.time - 1 == 0)
					result += task.score;
				else
					stack.push(new Task(task.score, task.time - 1));
				
				continue;
			}
			
			int a = Integer.parseInt(st.nextToken()); 
			int t = Integer.parseInt(st.nextToken()); 
			
			if(t == 1)
				result += a;
			else
				stack.push(new Task(a, t - 1));
		}
		
		System.out.println(result); 
	}

}