import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static int[] visited;
	public static ArrayList<Integer>[] people;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); 
		st = new StringTokenizer(br.readLine());
		
		int p1 = Integer.parseInt(st.nextToken());
		int p2 = Integer.parseInt(st.nextToken());
		
		people = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++)
			people[i] = new ArrayList<>();
		
		int M = Integer.parseInt(br.readLine());
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			
			people[parent].add(child);
			people[child].add(parent);
		}
		
		visited = new int[N + 1];
		dfs(p1, 0);
		
		if(visited[p2] == 0)
			System.out.println(-1);
		else
			System.out.println(visited[p2]);
	}
	
	public static void dfs(int start, int value) {
		visited[start] = value;
		
		for(int i = 0; i < people[start].size(); i++) {
			int next = people[start].get(i);
			if(visited[next] == 0)
				dfs(next, value + 1);
		}
	}

}