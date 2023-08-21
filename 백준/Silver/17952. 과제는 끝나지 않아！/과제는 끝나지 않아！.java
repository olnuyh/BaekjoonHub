import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Task implements Comparable<Task>{
	int score, start, end;
	
	public Task(int score, int start, int end) { 
		this.score = score; 
		this.start = start;
		this.end = end; 
	}

	@Override
	public int compareTo(Task o) {
		return o.start - this.start;
	}
}

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st; 
		
		int n = Integer.parseInt(br.readLine()); 
		
		PriorityQueue<Task> pq = new PriorityQueue<>();
		
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken()); 
			
			if(c == 0) continue;
			
			int a = Integer.parseInt(st.nextToken()); 
			int t = Integer.parseInt(st.nextToken()); 
			
			pq.offer(new Task(a, i, t)); 
		}
		
		int result = 0; 
		int busy = 0; 
		
		while(!pq.isEmpty()) { 
			Task task = pq.poll(); 
			
			if(n - (task.start - 1 + busy) >= task.end) {
				result += task.score; 
				busy += task.end; 
			}else 
				busy += n - (task.start - 1 + busy);
		}
		
		System.out.println(result); 
	}

}