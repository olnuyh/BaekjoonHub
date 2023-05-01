import java.util.ArrayList;
import java.util.Scanner;

public class Main{
	static ArrayList<Integer>[] A;
	static boolean[] visited;
	static boolean isPresent;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		A = new ArrayList[n];
		
		for(int i = 0; i < n; i++)
			A[i] = new ArrayList<Integer>();
		
		for(int i = 0; i < m; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			A[a].add(b);
			A[b].add(a);
		}
		
		visited = new boolean[n];
		
		for(int i = 0; i < n; i++) {
			DFS(i, 1);
			if(isPresent)
				break;
		}
		
		if(isPresent)
			System.out.println(1);
		else
			System.out.println(0);
	}

	public static void DFS(int num, int count) {
		if(count == 5 || isPresent) {
			isPresent = true;
			return;
		}
		
		visited[num] = true;
		
		for(int i : A[num]) {
			if(!visited[i])
				DFS(i, count + 1);
		}
		
		visited[num] = false;
	}
}