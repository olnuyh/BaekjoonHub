import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static ArrayList<Integer>[] friends;
	public static boolean[] visited;
	public static boolean isPossible;
	
	public static void dfs(int v, int depth) {
		if(depth == 5) {
			isPossible = true;
			return;
		}
			
		for(int i = 0; i < friends[v].size(); i++) {
			int next = friends[v].get(i);
			
			if(!visited[next]) {
				visited[next] = true;
				dfs(next, depth + 1);
				visited[next] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		friends = new ArrayList[n];
		for(int i = 0; i < n; i++)
			friends[i] = new ArrayList<>();
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			friends[a].add(b);
			friends[b].add(a);
		}
		
		for(int i = 0; i < n; i++) {
			visited = new boolean[n];
			visited[i] = true;
			isPossible = false;
			dfs(i, 1);
			
			if(isPossible)
				break;
		}
		
		if(isPossible)
			System.out.println(1);
		else
			System.out.println(0);
	}

}