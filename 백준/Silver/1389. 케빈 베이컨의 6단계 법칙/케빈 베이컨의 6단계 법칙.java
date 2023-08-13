import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static ArrayList<Integer>[] relationship;
	public static boolean[] visited;
	
	public static int bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(start);
		visited[start] = true;
		
		int cnt = 0;
		int stage = 1;
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			while(--size >= 0) {
				int now = q.poll();
				
				for(int i = 0; i < relationship[now].size(); i++) {
					int next = relationship[now].get(i);
					
					if(!visited[next]) {
						visited[next] = true;
						q.add(next);
						cnt += stage;
					}
				}
			}
			
			stage++;
		}
		
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		relationship = new ArrayList[n + 1];
		
		for(int i = 1; i <= n; i++)
			relationship[i] = new ArrayList<Integer>();
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			relationship[a].add(b);
			relationship[b].add(a);
		}
		
		int count = Integer.MAX_VALUE;
		int person = 0;
		
		for(int i = n; i > 0; i--) {
			visited = new boolean[n + 1];
			int result = bfs(i);
			
			if(result <= count) {
				count = result;
				person = i;
			}
		}
		
		System.out.println(person);
	}

}