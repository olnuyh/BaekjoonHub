import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int n, k;
	public static int[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
	
		visited = new int[1000001];
		bfs(n);
		
		System.out.println(visited[k] - 1);
	}

	public static void bfs(int v) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(v);
		visited[v] = 1;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			if(2 * now <= 100000 && visited[2 * now] == 0) {
				q.offer(2 * now);
				visited[2 * now] = visited[now] + 1;
			}
			
			if(now + 1 <= 100000 && visited[now + 1] == 0) {
				q.offer(now + 1);
				visited[now + 1] = visited[now] + 1;
			}
			
			if(now - 1 >= 0 && visited[now - 1] == 0) {
				q.offer(now - 1);
				visited[now - 1] = visited[now] + 1;
			}
		}
	}
}