import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Town implements Comparable<Town>{
	int target, time;
	public Town(int target, int time) {
		this.target = target;
		this.time = time;
	}
	
	@Override
	public int compareTo(Town o) {
		return this.time - o.time;
	}
}

public class Main {
	public static boolean[] visited;
	public static ArrayList<Town>[] list;
	public static int[] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n + 1];
		for(int i = 1; i <= n; i++)
			list[i] = new ArrayList<Town>();
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			list[s].add(new Town(e, t));
		}
		
		int[] result = new int[n + 1];
		for(int i = 1; i <= n; i++) {
			visited = new boolean[n + 1];
			dist = new int[n + 1];
			for(int j = 1; j <= n; j++)
				dist[j] = Integer.MAX_VALUE;
			dist[i] = 0;
			
			checkTime(i);
			
			if(i == x) {
				for(int j = 1; j <= n; j++) {
					if(i == j) continue;
					result[j] += dist[j];
				}
			}else
				result[i] += dist[x];
		}
		
		int maxTime = Integer.MIN_VALUE;
		for(int i = 0; i <= n; i++)
			maxTime = Math.max(maxTime, result[i]);
		
		System.out.println(maxTime);
	}
	
	public static void checkTime(int startTown) {
		PriorityQueue<Town> pq = new PriorityQueue<>();
		pq.add(new Town(startTown, 0));
		
		while(!pq.isEmpty()) {
			Town nowTown = pq.poll();
			int now = nowTown.target;
			
			if(!visited[now]) {
				visited[now] = true;
			
				for(Town t : list[now]) {
					if(dist[t.target] > dist[now] + t.time) {
						dist[t.target] = dist[now] + t.time;
						pq.add(new Town(t.target, dist[t.target]));
					}
				}	
			}
		}
		
	}

}