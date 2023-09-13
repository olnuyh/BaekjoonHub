import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int H, W;
	public static int[][] board;
	public static boolean[][] hole;
	
	public static int[] dr = {-1, 1, 0, 0};
	public static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		board = new int[H][W];
		for(int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < W; j++) 
				board[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int time = 0;
		
		Queue<int []> cheeze = new ArrayDeque<>();
		int leftCheeze;
		while(true) {
			leftCheeze = 0;
			
			// 1. 치즈 구멍 찾기(bfs를 통해 치즈 겉 부분 모두 체크)
			hole = new boolean[H][W];
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					if(board[i][j] == 1) {
						leftCheeze++;
						hole[i][j] = true;
					}
				}
			}
			
			checkNotHole();
			
			// 2. 치즈 녹이기(구멍과 인접한 치즈 제외)
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					if(board[i][j] == 1) {
						if(checkMelt(i, j))
							cheeze.offer(new int[] {i, j});
					}
				}
			}
			
			time++;
			if(leftCheeze == cheeze.size())
				break;
			
			leftCheeze -= cheeze.size();
			while(!cheeze.isEmpty()) {
				int[] pos = cheeze.poll();
				board[pos[0]][pos[1]] = 0;
			}		
		}
		
		System.out.println(time);
		System.out.println(leftCheeze);
	}
	
	public static void checkNotHole() {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {0, 0});
		hole[0][0] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int i = 0; i < 4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				
				if(nr < 0 || nr >= H || nc < 0 || nc >= W) continue;
				
				if(board[nr][nc] == 0 && !hole[nr][nc]) {
					q.offer(new int[] {nr, nc});
					hole[nr][nc] = true;
				}
			}
		}
	}

	public static boolean checkMelt(int sr, int sc) {
		int cnt = 0;
		for(int d = 0; d < 4; d++) {
			int nr = sr + dr[d];
			int nc = sc + dc[d];
			
			if(nr < 0 || nr >= H || nc < 0 || nc >= W) continue;
			
			if(board[nr][nc] == 0 && !hole[nr][nc])
				continue;
			else if(board[nr][nc] == 0 && hole[nr][nc])
				cnt++;
		}
		
		if(cnt == 0)
			return false;
		else
			return true;
	}
}