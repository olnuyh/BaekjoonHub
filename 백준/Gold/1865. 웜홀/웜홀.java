import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Edge{
	int start, end, time;
	
	public Edge(int start, int end, int time) {
		this.start = start;
		this.end = end;
		this.time = time;
	}
}

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			ArrayList<Edge> edges = new ArrayList<>();
			
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				
				edges.add(new Edge(s, e, d));
				edges.add(new Edge(e, s, d));
			}
			
			for(int i = 0; i < w; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				
				edges.add(new Edge(s, e, -d));
			}
			
			boolean isPossible = false;
			int[] dist = new int[n + 1];
			
			outer: for(int i = 1; i <= n; i++) {
				Arrays.fill(dist, Integer.MAX_VALUE);
				dist[i] = 0;
				boolean update = false;
				
				for(int j = 1; j < n; j++) {
					update = false;
					
					for(int k = 0; k < edges.size(); k++) {
						Edge edge = edges.get(k);
						if(dist[edge.start] != Integer.MAX_VALUE && dist[edge.end] > dist[edge.start] + edge.time) {
							dist[edge.end] = dist[edge.start] + edge.time;
							update = true;
						}	
					}
					
					if(!update)
						break;
				}
				
				if(update) {
					for(int k = 0; k < edges.size(); k++) {
						Edge edge = edges.get(k);
						if(dist[edge.start] != Integer.MAX_VALUE && dist[edge.end] > dist[edge.start] + edge.time) {
							isPossible = true;
							break outer;
						}	
					}
				}
			} 
			
			if(isPossible)
				sb.append("YES\n");
			else
				sb.append("NO\n");
		}
		
		System.out.println(sb);
	}
}