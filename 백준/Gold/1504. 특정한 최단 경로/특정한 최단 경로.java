import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static final int INF = 1000000000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		int[][] dist = new int[n + 1][n + 1];
		
		for(int i = 0; i <= n; i++)
			Arrays.fill(dist[i], INF);
		
		for(int i = 0; i <= n; i++)
			dist[i][i] = 0;
		
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			dist[a][b] = c;
			dist[b][a] = c;
		}
		
		st = new StringTokenizer(br.readLine());
		int p1 = Integer.parseInt(st.nextToken());
		int p2 = Integer.parseInt(st.nextToken());
		
		for(int k = 1; k <= n; k++) {
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= n; j++) {
					if(dist[i][j] > dist[i][k] + dist[k][j])
						dist[i][j] = dist[i][k] + dist[k][j];
				}
			}
		}
		
		int d1 = INF;
		int d2 = INF;
		
		if(dist[1][p1] != INF && dist[p1][p2] != INF && dist[p2][n] != INF)
			d1 = dist[1][p1] + dist[p1][p2] + dist[p2][n];
		
		if(dist[1][p2] != INF && dist[p2][p1] != INF && dist[p1][n] != INF)
			d2 = dist[1][p2] + dist[p2][p1] + dist[p1][n];
		
		int ans = Math.min(d1, d2);
		
		if(ans == INF)
			System.out.println(-1);
		else
			System.out.println(ans);
	}

}