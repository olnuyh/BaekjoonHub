import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int n, m;
	public static int[] dr = {-1, 1, 0, 0};
	public static int[] dc = {0, 0, -1, 1};
	public static int[][] map;
	public static int[][][] visited;
	public static int minDistance;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];

		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			for(int j = 0; j < m; j++) 
				map[i][j] = str.charAt(j) - '0';
		}
		
		minDistance = Integer.MAX_VALUE;
		// 벽을 부순 경우와 벽을 부수지 않은 경우를 둘 다 저장하기 위해 3차원 배열 사용
		visited = new int[2][n][m];
		minDistance = Math.min(minDistance, bfs());
		
		System.out.println(minDistance);
	}

	public static int bfs() {
		Queue<int []> q = new ArrayDeque<>();
		q.offer(new int[] {0, 0, 0});
		visited[0][0][0] = 1;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int crush = cur[0];
			int r = cur[1];
			int c = cur[2];
			
			if(r == n - 1 && c == m - 1)
				return visited[crush][r][c];
						
			for(int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
			
				// 다음 이동할 칸에 벽이 없는 경우
				if(map[nr][nc] == 0 && visited[crush][nr][nc] == 0) {
					visited[crush][nr][nc] = visited[crush][r][c] + 1;
					q.offer(new int[] {crush, nr, nc});
				}
				// 다음 이동할 칸에 벽이 있는 경우
				else if(map[nr][nc] == 1 && visited[crush][nr][nc] == 0) {
					// 벽을 아직 안 부순 경우
					if(crush == 0) {
						visited[1][nr][nc] = visited[crush][r][c] + 1;
						q.offer(new int[] {1, nr, nc});
					}
					// 벽을 이미 부순 경우
					else
						continue;
				}
			}
		}
	
		return -1;
	}
	
}