import java.util.ArrayList;
import java.util.Scanner;

public class Main{
	public static boolean[] visited;
	public static ArrayList<Integer>[] A;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		A = new ArrayList[n + 1];
		
		for(int i = 1; i <= n; i++)
			A[i] = new ArrayList<Integer>();
		
		for(int i = 0; i < m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			
			A[u].add(v);
			A[v].add(u);
		}
		
		visited = new boolean[n + 1];
		
		int count = 0;
		for(int i = 1; i <= n; i++) {
			if(!visited[i]) {
				DFS(i);
				count++;
			}
		}
		
		System.out.println(count);
	}
	
	public static void DFS(int node) {
		visited[node] = true;
		
		for(int i = 0; i < A[node].size(); i++) {
			if(!visited[A[node].get(i)]) {
				visited[A[node].get(i)] = true;
				DFS(A[node].get(i));
			}
		}
	}
}