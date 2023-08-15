import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class City implements Comparable<City>{
	int city, value;
	
	City(int city, int value){
		this.city = city;
		this.value = value;
	}

	@Override
	public int compareTo(City o) {
		return this.value - o.value;
	}
}

public class Main {	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		ArrayList<City>[] graph = new ArrayList[n + 1];

		for(int i = 1; i <= n; i++)
			graph[i] = new ArrayList<City>();
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph[s].add(new City(e, w));
		}
		
		st = new StringTokenizer(br.readLine());
		int startCity = Integer.parseInt(st.nextToken());
		int endCity = Integer.parseInt(st.nextToken());
		
		boolean[] visited = new boolean[n + 1];
		int[] D = new int[n + 1];
		
		for(int i = 0; i <= n; i++)
			D[i] = Integer.MAX_VALUE;
		
		PriorityQueue<City> pq = new PriorityQueue<>();
		pq.add(new City(startCity, 0));
		D[startCity] = 0;
		
		while(!pq.isEmpty()) {
			City nowCity = pq.poll();
			int now = nowCity.city;
			
			if(!visited[now]) {
				visited[now] = true;
				for(City c : graph[now]) {
					if(D[c.city] > D[now] + c.value) {
						D[c.city] = D[now] + c.value;
						pq.add(new City(c.city, D[c.city]));
					}
				}
			}	
		}
		
		System.out.println(D[endCity]);
	}

}