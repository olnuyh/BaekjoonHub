import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Fish{
	int r, c, dir;
	
	public Fish(int r, int c, int dir) {
		this.r = r;
		this.c = c;
		this.dir = dir;
	}
}

public class Main {
	public static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	public static int[] dc = {0, -1, -1, -1, 0, 1, 1, 1};
	
	public static int maxSum;
	//public static int[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][] board = new int[4][4];
		Map<Integer, Fish> hm = new HashMap<>();
		
		for(int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 4; j++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken()) - 1;
				
				board[i][j] = a;
				hm.put(a, new Fish(i, j, b));
			}
		}
		
		int first = board[0][0];
		Fish shark = hm.get(board[0][0]);
		hm.remove(board[0][0]);
		board[0][0] = -1;
		
		maxSum = 0;
		move(board, hm, shark, first);
		
		System.out.println(maxSum);
	}

	public static void move(int[][] origin, Map<Integer, Fish> originHm, Fish shark, int sum) {
		maxSum = Math.max(maxSum, sum);
		
		int[][] board = new int[4][4];
		
		for(int i = 0; i < 4; i++) 
			board[i] = origin[i].clone();
		
		Map<Integer, Fish> hm = new HashMap<>(originHm);
		
		// 물고기 번호 작은 순부터 이동
		for(int i = 1; i <= 16; i++) {
			if(hm.get(i) == null) continue;
			
			Fish fish = hm.get(i);
			int dir = fish.dir;
			
			for(int j = 0; j < 8; j++) {
				int nDir = (dir + j) % 8;
				
				int nr = fish.r + dr[nDir];
				int nc = fish.c + dc[nDir];
				
				if(nr < 0 || nr >= 4 || nc < 0 || nc >= 4 || board[nr][nc] == -1) continue;
				
				if(board[nr][nc] == 0) { // 빈 칸일 경우 => 현재 물고기만 이동
					board[fish.r][fish.c] = 0;
					board[nr][nc] = i;
					hm.put(i, new Fish(nr, nc, nDir));

					break;
				}else { // 다른 물고기가 있는 경우 => 두 물고기끼리 서로 위치 바꾸기
					board[fish.r][fish.c] = board[nr][nc];
					Fish changeFish = hm.get(board[nr][nc]);
					hm.put(board[nr][nc], new Fish(fish.r, fish.c, changeFish.dir));

					hm.put(i, new Fish(nr, nc, nDir));
					board[nr][nc] = i;
					
					break;
				}
			}
		}
		
		// 상어 이동

		for(int i = 1; i <= 3; i++) {
			int nr = shark.r + dr[shark.dir] * i;
			int nc = shark.c + dc[shark.dir] * i;
			
			if(nr < 0 || nr >= 4 || nc < 0 || nc >= 4 || board[nr][nc] == 0) continue;
			
			int num = board[nr][nc];
			Fish tmp = hm.get(num);
			board[nr][nc] = -1;
			board[shark.r][shark.c] = 0;
			hm.remove(num);
			
			move(board, hm, new Fish(nr, nc, tmp.dir), sum + num);
			
			hm.put(num, tmp);
			board[nr][nc] = num;
			board[shark.r][shark.c] = -1;
		}
	}
}