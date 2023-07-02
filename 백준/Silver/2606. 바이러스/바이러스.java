import java.util.*;

public class Main {
	public static ArrayList<Integer>[] network;
	public static boolean[] visited;
	public static int count = 0;
	
	public static void DFS(int v)
	{
		visited[v] = true;
		
		for(int i = 0; i < network[v].size(); i++)
		{
			int next = network[v].get(i);
			if(!visited[next])
			{
				DFS(next);
				count++;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		network = new ArrayList[n + 1];
		for(int i = 1; i <= n; i++)
			network[i] = new ArrayList<>();
			
		for(int i = 0; i < m; i++)
		{
			int s = sc.nextInt();
			int e = sc.nextInt();
			
			network[s].add(e);
			network[e].add(s);
		}

		visited = new boolean[n + 1];
		DFS(1);
		
		System.out.println(count);
	}
}