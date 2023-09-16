import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int L;
	public static int[] end;
	public static int[] dr = {-2, -2, -1, -1, 1, 1, 2, 2};
	public static int[] dc = {-1, 1, -2, 2, -2, 2, -1, 1};
	public static int[][] board;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			L = Integer.parseInt(br.readLine());
			board = new int[L][L];
			
			int[] start = new int[2];
			st = new StringTokenizer(br.readLine());
			start[0] = Integer.parseInt(st.nextToken());
			start[1] = Integer.parseInt(st.nextToken());
			
			end = new int[2];
			st = new StringTokenizer(br.readLine());
			end[0] = Integer.parseInt(st.nextToken());
			end[1] = Integer.parseInt(st.nextToken());
			
			bfs(start[0], start[1]);
			
			sb.append((board[end[0]][end[1]] - 1) + "\n");
		}
		
		System.out.println(sb);
	}
	
	public static void bfs(int sr, int sc) {
		Queue<int []> q = new ArrayDeque<>();
		q.offer(new int[] {sr, sc});
		board[sr][sc] = 1;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int i = 0; i < 8; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				
				if(nr < 0 || nr >= L || nc < 0 || nc >= L) continue;
			
				if(board[nr][nc] == 0) {
					q.offer(new int[] {nr, nc});
					board[nr][nc] = board[cur[0]][cur[1]] + 1;
					
					if(nr == end[0] && nc == end[1])
						return;
				}
			}
		}
	}

}