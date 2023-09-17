import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Problem implements Comparable<Problem>{
	int deadline, cupNoodle;
	
	public Problem(int deadline, int cupNoodle) {
		this.deadline = deadline;
		this.cupNoodle = cupNoodle;
	}

	@Override
	public int compareTo(Problem o) {
		if(this.deadline == o.deadline)
			return o.cupNoodle - this.cupNoodle;
		return this.deadline - o.deadline;
	}	
}

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());

		List<Problem> list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int D = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			list.add(new Problem(D, C));
		}
		
		Collections.sort(list);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i = 0; i < N; i++) {
			Problem p = list.get(i);
			pq.add(p.cupNoodle);
			
			if(pq.size() > p.deadline)
				pq.poll();
		}
		
		int maxCupNoodle = 0;
		while(!pq.isEmpty())
			maxCupNoodle += pq.poll();
		
		System.out.println(maxCupNoodle);
	}

}