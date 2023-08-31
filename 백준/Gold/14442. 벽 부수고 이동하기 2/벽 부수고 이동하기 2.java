import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int N, M, K;
	public static int[] dr = {-1, 1, 0, 0};
	public static int[] dc = {0, 0, -1, 1};
	public static int[][] map;
	public static int[][][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++)
				map[i][j] = str.charAt(j) - '0';
		}
		
		System.out.println(bfs());
	}

	public static int bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		visited = new int[K + 1][N][M];
		visited[0][0][0] = 1;
		q.offer(new int[] {0, 0, 0});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int crush = cur[0];
			int r = cur[1];
			int c = cur[2];
			
			if(r == N - 1 && c == M - 1)
				return visited[crush][r][c];
			
			for(int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				
				// 이동하려는 칸에 벽이 없을 때
				if(map[nr][nc] == 0 && visited[crush][nr][nc] == 0) {
					visited[crush][nr][nc] = visited[crush][r][c] + 1;
					q.offer(new int[] {crush, nr, nc});
				}else if(map[nr][nc] == 1 && crush < K && visited[crush + 1][nr][nc] == 0){ // 이동하려는 칸에 벽이 있을 때
					// 아직 벽을 더 부술 수 있는 경우 벽을 부수고 이동
					visited[crush + 1][nr][nc] = visited[crush][r][c] + 1;
					q.offer(new int[] {crush + 1, nr, nc});
					
				}
			}
		}
		
		return -1;
	}
}