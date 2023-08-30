import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int w, h, k;
	public static int[][] map;
	public static int[][] horse = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
	public static int[][] monkey = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public static int[][][] move;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		k = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		map = new int[h][w];
		
		for(int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < w; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		move = new int[k + 1][h][w];
		System.out.println(bfs());
	}

	public static int bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {0, 0, 0});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int horseCnt = cur[0];
			int r = cur[1];
			int c = cur[2];
			
			if(r == h - 1 && c == w - 1)
				return move[horseCnt][r][c];
			
			// 말 이동 횟수를 다 사용한 경우 => 원숭이로만 이동 가능
			if(horseCnt == k) {
				for(int i = 0; i < 4; i++) {
					int nr = r + monkey[i][0];
					int nc = c + monkey[i][1];
					
					if(!isIn(nr, nc)) continue;
					
					if(map[nr][nc] == 0 && move[horseCnt][nr][nc] == 0) {
						move[horseCnt][nr][nc] = move[horseCnt][r][c] + 1;
						q.offer(new int[] {horseCnt, nr, nc});
					}
				}
			}
			// 말 이동 횟수를 다 사용하지 않은 경우 => 말 이동 횟수를 한 번 더 사용해서 이동하거나, 원숭이로 이동 가능
			else if(horseCnt < k){
				for(int i = 0; i < 8; i++) {
					int nr = r + horse[i][0];
					int nc = c + horse[i][1];
					
					if(!isIn(nr, nc)) continue;
					
					if(map[nr][nc] == 0 && move[horseCnt + 1][nr][nc] == 0) {
						move[horseCnt + 1][nr][nc] = move[horseCnt][r][c] + 1;
						q.offer(new int[] {horseCnt + 1, nr, nc});
					}
				}
				
				for(int i = 0; i < 4; i++) {
					int nr = r + monkey[i][0];
					int nc = c + monkey[i][1];
					
					if(!isIn(nr, nc)) continue;
					
					if(map[nr][nc] == 0 && move[horseCnt][nr][nc] == 0) {
						move[horseCnt][nr][nc] = move[horseCnt][r][c] + 1;
						q.offer(new int[] {horseCnt, nr, nc});
					}
				}
			}
			
		}
		
		return -1;
	}
	
	public static boolean isIn(int r, int c) {
		if(r < 0 || r >= h || c < 0 || c >= w)
			return false;
		return true;
	}
}