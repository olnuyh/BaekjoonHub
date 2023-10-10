import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class FineDust{
	int r, c, amount;
	
	public FineDust(int r, int c, int amount) {
		this.r = r;
		this.c = c;
		this.amount = amount;
	}
}

public class Main {
	public static int[][] deltas1 = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	public static int[][] deltas2 = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

	public static Queue<FineDust> fineDustList;
	public static int[][] room;
	public static int R, C;
	public static int[][] cleaner;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		fineDustList = new ArrayDeque<>();
		room = new int[R][C];
		
		cleaner = new int[2][];
		int tmp = 0;
		
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < C; j++) {
				int val = Integer.parseInt(st.nextToken());
				if(val > 0)
					fineDustList.offer(new FineDust(i, j, val));
				else if(val == -1) {
					room[i][j] = -1;
					cleaner[tmp++] = new int[] {i, j};
				}
			}
		}
		
		for(int i = 0; i < T; i++) {
			// 미세먼지 확산
			spread();
			
			// 공기청정기 청소
			clean();
			
			for(int j = 0; j < R; j++) {
				for(int k = 0; k < C; k++) {
					if(room[j][k] > 0) {
						fineDustList.offer(new FineDust(j, k, room[j][k]));
						room[j][k] = 0;
					}
				}
			}
		}
		
		int leftAmount = 0;
		while(!fineDustList.isEmpty())
			leftAmount += fineDustList.poll().amount;
		
		System.out.println(leftAmount);
	}

	public static void spread() {
		while(!fineDustList.isEmpty()) {
			FineDust cur = fineDustList.poll();
			int cnt = 0;
			// 확산되는 개수 세기
			for(int d = 0; d < 4; d++) {
				int nr = cur.r + deltas1[d][0];
				int nc = cur.c + deltas1[d][1];
				
				if(nr < 0 || nr >= R || nc < 0 || nc >= C || room[nr][nc] == -1) continue;
				cnt++;
			}
			
			// 미세먼지 확산
			for(int d = 0; d < 4; d++) {
				int nr = cur.r + deltas1[d][0];
				int nc = cur.c + deltas1[d][1];
				
				if(nr < 0 || nr >= R || nc < 0 || nc >= C || room[nr][nc] == -1) continue;
				room[nr][nc] += cur.amount / 5;
			}
			
			room[cur.r][cur.c] += cur.amount - (cur.amount / 5) * cnt;
		}
	}
	
	public static void clean() {
		// 위쪽 공기청정기 청소
		int r = cleaner[0][0] - 1;
		int c = cleaner[0][1];
		
		int d = 0;
		while(d < 4) {
			int nr = r + deltas1[d][0];
			int nc = c + deltas1[d][1];
			
			if(nr < 0 || nr > cleaner[0][0] || nc < 0 || nc >= C) {
				d++;
				continue;
			}
			
			room[r][c] = room[nr][nc];
			r = nr;
			c = nc;
		}
		
		room[cleaner[0][0]][cleaner[0][1] + 1] = 0;
		
		// 아래쪽 공기청정기 청소
		r = cleaner[1][0] + 1;
		c = cleaner[1][1];
		
		d = 0;
		while(d < 4) {
			int nr = r + deltas2[d][0];
			int nc = c + deltas2[d][1];
			
			if(nr < cleaner[1][0] || nr >= R || nc < 0 || nc >= C) {
				d++;
				continue;
			}
			
			room[r][c] = room[nr][nc];
			r = nr;
			c = nc;
		}
		
		room[cleaner[1][0]][cleaner[1][1] + 1] = 0;
	}
}