import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int n;
	public static int minCost;
	public static int[][] W;
	public static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		W = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++)
				W[i][j] = Integer.parseInt(st.nextToken());
		}
		
		minCost = Integer.MAX_VALUE;
		
		visited = new boolean[n];
		visited[0] = true;
		go(1, 0, 0);
		
		System.out.println(minCost);
	}

	public static void go(int cnt, int cost, int start) {
		if(cnt == n) {
			if(W[start][0] == 0)
				return;
			minCost = Math.min(minCost, cost + W[start][0]);
			return;
		}
		
		if(cost >= minCost)
			return;
		
		for(int i = 0; i < n; i++) {
			if(!visited[i] && W[start][i] != 0) {
				visited[i] = true;
				go(cnt + 1, cost + W[start][i], i);
				visited[i] = false;
			}
		}
	}
}