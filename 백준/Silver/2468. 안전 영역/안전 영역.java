import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int[] dr = {-1, 1, 0, 0};
	public static int[] dc = {0, 0, -1, 1};
	public static boolean[][] visited;
	public static int[][] region;
	public static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		region = new int[N][N];
		
		int maxHeight = Integer.MIN_VALUE;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				region[i][j] = Integer.parseInt(st.nextToken());
				maxHeight = Math.max(maxHeight, region[i][j]);
			}
		}
		
		int result = 1;
		
		for(int i = 1; i <= maxHeight; i++) {
			visited = new boolean[N][N];
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < N; k++) {
					if(region[j][k] > 0)
						region[j][k]--;
				}
			}
			
			int cnt = 0;
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < N; k++) {
					if(!visited[j][k] && region[j][k] > 0) {
						checkSafetyArea(j, k);
						cnt++;
					}
				}
			}
			
			result = Math.max(result, cnt);
		}
		
		System.out.println(result);
	}

	public static void checkSafetyArea(int sr, int sc) {
		Queue<int []> q = new ArrayDeque<>();
		visited[sr][sc] = true;
		q.offer(new int[] {sr, sc});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int i = 0; i < 4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				
				if(!visited[nr][nc] && region[nr][nc] != 0) {
					visited[nr][nc] = true;
					q.offer(new int[] {nr, nc});
				}
			}
		}
	}
}