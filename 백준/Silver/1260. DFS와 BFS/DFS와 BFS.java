import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main{
	static ArrayList<Integer>[] A;
	static boolean[] visited;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int v = sc.nextInt();
		
		A = new ArrayList[n + 1];
		
		for(int i = 1; i <= n; i++)
			A[i] = new ArrayList<Integer>();
		
		for(int i = 0; i < m; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			
			A[s].add(e);
			A[e].add(s);
		}
		
		for(int i = 1; i <= n; i++)
			Collections.sort(A[i]);
		
		visited = new boolean[n + 1];
		DFS(v);
		System.out.println();
		
		visited = new boolean[n + 1];
		BFS(v);
	}
	
	public static void DFS(int num){
		if(visited[num])
			return;
		
		visited[num] = true;
		System.out.print(num + " ");
		
		for(int i : A[num]) {
			if(!visited[i])
				DFS(i);
		}
	}
	
	public static void BFS(int num){
		Queue<Integer> q = new LinkedList<>();
		q.add(num);
		visited[num] = true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			System.out.print(now + " ");
			
			for(int i : A[now]) {
				if(!visited[i]) {
					visited[i] = true;
					q.add(i);
				}
			}
		}
	}
}