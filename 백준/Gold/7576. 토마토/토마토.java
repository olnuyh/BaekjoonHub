import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int[] dr = {-1, 1, 0, 0};
	public static int[] dc = {0, 0, -1, 1};
	
	public static Queue<int []> q;
	public static int n, m;
	public static int[][] box;
	public static boolean[][] visited;
	public static int unripe;
	
	public static int bfs() {
		int time = -1;
		
		while(!q.isEmpty()) {
			int size = q.size();
			while(--size >= 0) {
				int[] now = q.poll();
				
				for(int i = 0; i < 4; i++) {
					int nr = now[0] + dr[i];
					int nc = now[1] + dc[i];
					
					if(nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
					
					if(!visited[nr][nc] && box[nr][nc] == 0) {
						visited[nr][nc] = true;
						box[nr][nc] = 1;
						unripe--;
						q.offer(new int[] {nr, nc});
					}
				}
			}
			time++;
		}
		
		return time;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		box = new int[n][m];
		
		q = new ArrayDeque<>();
		visited = new boolean[n][m];
		unripe = 0;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if(box[i][j] == 1) {
					q.offer(new int[] {i, j});
					visited[i][j] = true;
				}
				else if(box[i][j] == 0)
					unripe++;
			}
		}
		
		int time = bfs();
		
		if(unripe == 0)
			System.out.println(time);
		else
			System.out.println(-1);
	}

}