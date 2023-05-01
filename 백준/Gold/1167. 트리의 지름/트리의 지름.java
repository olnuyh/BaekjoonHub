import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static boolean[] visited;
	static ArrayList<Node>[] A;
	static int[] distance;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		int v = Integer.parseInt(br.readLine());
		
		A = new ArrayList[v + 1];
		for(int i = 1; i <= v; i++)
			A[i] = new ArrayList<Node>();
			
		for(int i = 0; i < v; i++) {
			stk = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(stk.nextToken());
			
			while(true) {
				int e = Integer.parseInt(stk.nextToken());
				if(e == - 1)
					break;
				int w = Integer.parseInt(stk.nextToken());
				A[s].add(new Node(e, w));
			}
		}
		
		visited = new boolean[v + 1];
		distance = new int[v + 1];
		
		BFS(1);
		int max = 1;
		
		for(int i = 2; i <= v; i++)
		{
			if(distance[max] < distance[i])
				max = i;
		}
		
		visited = new boolean[v + 1];
		distance = new int[v + 1];
		BFS(max);
		
		Arrays.sort(distance);
		System.out.println(distance[v]);
	}
	
	public static void BFS(int num) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(num);
		visited[num] = true;
		
		while(!q.isEmpty())
		{
			int now = q.poll();
			for(Node i : A[now])
			{
				if(!visited[i.end]) {
					visited[i.end] = true;
					q.add(i.end);
					distance[i.end] = distance[now] + i.weight;
				}
			}
		}
	}
}

class Node{
	int end;
	int weight;
	
	Node(int end, int weight){
		this.end = end;
		this.weight = weight;
	}
}