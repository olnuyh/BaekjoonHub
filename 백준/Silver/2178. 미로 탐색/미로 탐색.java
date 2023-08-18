import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int n, m;
	public static int[][] maze;
	public static int[][] cnt;
	public static int[] dr = {-1, 1, 0, 0};
	public static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		maze = new int[n][m];
		cnt = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			for(int j = 0; j < m; j++)
				maze[i][j] = str.charAt(j) - '0';
		}
		
		bfs(0, 0);
		System.out.println(cnt[n - 1][m - 1]);
	}
	
	public static void bfs(int sr, int sc) {
		Queue<int []> queue = new ArrayDeque<>();
		queue.offer(new int[] {sr, sc});
		cnt[sr][sc] = 1;
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			for(int i = 0; i < 4; i++) {
				int nr = now[0] + dr[i];
				int nc = now[1] + dc[i];
				
				if(nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
				
				if(cnt[nr][nc] == 0 && maze[nr][nc] == 1) {
					queue.offer(new int[] {nr, nc});
					cnt[nr][nc] = cnt[now[0]][now[1]] + 1;
				}
			}
		}
	}

}