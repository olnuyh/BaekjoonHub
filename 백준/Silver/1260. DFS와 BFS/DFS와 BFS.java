import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static boolean[] visited;
	public static StringBuilder sb;
	public static ArrayList<Integer>[] list;
	
	public static void dfs(int num) {
		visited[num] = true;
		sb.append(num + " ");
		
		for(int i = 0; i < list[num].size(); i++) {
			int next = list[num].get(i);
			if(!visited[next])
				dfs(next);
		}
	}
	
	public static void bfs(int num) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(num);
		visited[num] = true;
		
		while(!q.isEmpty()) {
			int v = q.poll();
			sb.append(v + " ");
			for(int i = 0; i < list[v].size(); i++) {
				int next = list[v].get(i);
				if(!visited[next]) {
					q.add(next);
					visited[next] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n + 1];
		
		for(int i = 1; i <= n; i++)
			list[i] = new ArrayList<>();
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			list[s].add(e);
			list[e].add(s);
		}
		
		for(int i = 1; i <= n; i++)
			Collections.sort(list[i]);
		
		visited = new boolean[n + 1];
		dfs(v);
		sb.append("\n");
		visited = new boolean[n + 1];
		bfs(v);
		
		System.out.println(sb);
	}

}