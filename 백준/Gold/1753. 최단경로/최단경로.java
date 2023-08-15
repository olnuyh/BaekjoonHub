import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	int target, weight;
	
	Node(int target, int weight){
		this.target = target;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node o) {
		return this.weight - o.weight;
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		int k = Integer.parseInt(br.readLine());
		
		ArrayList<Node>[] graph = new ArrayList[v + 1];
		
		for(int i = 1; i <= v; i++)
			graph[i] = new ArrayList<>();
			
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int startNode = Integer.parseInt(st.nextToken());
			int endNode = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			graph[startNode].add(new Node(endNode, value));
		}
		
		int[] dist = new int[v + 1];
		boolean[] visited = new boolean[v + 1];
		
		for(int i = 1; i <= v; i++)
			dist[i] = Integer.MAX_VALUE;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(k, 0));
		dist[k] = 0;
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int target = node.target;
			
			if(!visited[target]) {
				visited[target] = true;
				for(Node n : graph[target]) {
					if(dist[n.target] > dist[target] + n.weight) {
						dist[n.target] = dist[target] + n.weight;
						pq.add(new Node(n.target, dist[n.target]));
					}
				}
			}
		}
		
		for(int i = 1; i <= v; i++) {
			if(dist[i] == Integer.MAX_VALUE)
				sb.append("INF\n");
			else
				sb.append(dist[i]).append("\n");
		}
		
		System.out.println(sb);
	}

}