import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int[] dr = {-1, 1, 0, 0};
	public static int[] dc = {0, 0, -1, 1};
	public static boolean[][] paper;
	public static int M, N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		paper = new boolean[M][N];
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken());
			int ey = M - Integer.parseInt(st.nextToken());
			int ex = Integer.parseInt(st.nextToken());
			int sy = M - Integer.parseInt(st.nextToken());
			
			for(int r = sy; r < ey; r++) {
				for(int c = sx; c < ex; c++)
					paper[r][c] = true;
			}
		}
		
		ArrayList<Integer> area = new ArrayList<>();
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(!paper[i][j])
					area.add(bfs(i, j));
			}
		}
		
		Collections.sort(area);
		sb.append(area.size() + "\n");
		for(int num : area)
			sb.append(num + " ");
		
		System.out.println(sb);
	}
	
	public static int bfs(int sr, int sc) {
		int cnt = 0;
		
		Queue<int []> q = new ArrayDeque<>();
		q.offer(new int[] {sr, sc});
		paper[sr][sc] = true;
		cnt++;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int i = 0; i < 4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				
				if(nr < 0 || nr >= M || nc < 0 || nc >= N) continue;
			
				if(!paper[nr][nc]) {
					paper[nr][nc] = true;
					q.offer(new int[] {nr, nc});
					cnt++;
				}
			}
		}

		return cnt;
	}
}