import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static ArrayList<Integer>[] list;
	public static int[] visited;
	public static StringBuilder sb = new StringBuilder();
	public static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n + 1];
		
		for(int i = 1; i <= n; i++)
			list[i] = new ArrayList<>();
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			list[u].add(v);
			list[v].add(u);
		}
		
		for(int i = 1; i <= n; i++)
			Collections.sort(list[i]);
		
		visited = new int[n + 1];
		cnt = 1;
		
		dfs(r);
		
		for(int i = 1; i <= n; i++)
			System.out.println(visited[i]);
	}
	
	public static void dfs(int vertex) {
		visited[vertex] = cnt++;

		for(int i = 0; i < list[vertex].size(); i++) {
			int next = list[vertex].get(i);
			
			if(visited[next] == 0) 
				dfs(next);
		}
	}
}