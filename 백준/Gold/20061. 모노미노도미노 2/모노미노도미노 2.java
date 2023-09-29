import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int score;
	public static int[][] blue;
	public static int[][] green;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		blue = new int[4][6];
		green = new int[6][4];
		
		score = 0;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			// 블록 자리 찾기
			if(t == 1) { // 1*1 블록
				int c = findLocation(x);
				blue[x][c] = 1;
				
				int r = findLocationG(y);
				green[r][y] = 1;
			}else if(t == 2) { // 1*2 블록
				int c = findLocation(x);
				blue[x][c] = 1;
				blue[x][c - 1] = 1;
				
				int r1 = findLocationG(y);
				int r2 = findLocationG(y + 1);
				int r = Math.min(r1, r2);
				green[r][y] = 1;
				green[r][y + 1] = 1;
			}else { // 2*1 블록
				int c1 = findLocation(x);
				int c2 = findLocation(x + 1);
				int c = Math.min(c1, c2);
				blue[x][c] = 1;
				blue[x + 1][c] = 1;
				
				int r = findLocationG(y);
				green[r][y] = 1;
				green[r - 1][y] = 1;
			}
			
			// 파란색 이동 처리
			// 한 줄이 모두 찼는지 확인 후 찼으면 점수 올리고 블록 이동
			while(!checkLine())
				checkLine();
				
			// 연한 부분에 블록이 있는지 확인
			boolean[] check = new boolean[2];
			
			for(int c = 0; c < 2; c++) {
				for(int r = 0; r < 4; r++) {
					if(blue[r][c] == 1)
						check[c] = true;
				}
			}
			
			if(check[1]) {
				moveBlocks(5, 0);
				
				if(check[0])
					moveBlocks(5, 1);
			}
			
			// 초록색 이동 처리
			// 한 줄이 모두 찼는지 확인 후 찼으면 점수 올리고 블록 이동
			while(!checkLineG())
				checkLineG();
				
			// 연한 부분에 블록이 있는지 확인
			check = new boolean[2];
			
			for(int r = 0; r < 2; r++) {
				for(int c = 0; c < 4; c++) {
					if(green[r][c] == 1)
						check[r] = true;
				}
			}
			
			if(check[1]) {
				moveBlocksG(5, 0);
				
				if(check[0])
					moveBlocksG(5, 1);
			}
		}
		
		int cnt = 0;
		for(int i = 0; i < 4; i++) {
			for(int j = 2; j < 6; j++) {
				if(blue[i][j] == 1)
					cnt++;
			}
		}
		
		
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 4; j++) {
				if(green[i][j] == 1)
					cnt++;
			}
		}
		
		System.out.println(score);
		System.out.println(cnt);
	}

	public static int findLocation(int r) { // 파란색 새로운 블록 위치 찾기
		for(int c = 0; c < 6; c++) {
			if(blue[r][c] == 0)
				continue;
			else
				return c - 1;
		}
		
		return 5;
	}
	
	public static int findLocationG(int c) { // 초록색 새로운 블록 위치 찾기
		for(int r = 0; r < 6; r++) {
			if(green[r][c] == 0)
				continue;
			else
				return r - 1;
		}
		
		return 5;
	}
	
	public static boolean checkLine() { // 파란색 한 줄이 다 찼는지 확인
		for(int c = 5; c >= 2; c--) {
			int sum = 0;
			for(int r = 0; r < 4; r++)
				sum += blue[r][c];
			
			if(sum == 4) {
				score++;
				moveBlocks(c, 0);
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean checkLineG() { // 초록색 한 줄이 다 찼는지 확인
		for(int r = 5; r >= 2; r--) {
			int sum = 0;
			for(int c = 0; c < 4; c++)
				sum += green[r][c];
			
			if(sum == 4) {
				score++;
				moveBlocksG(r, 0);
				return false;
			}
		}
		
		return true;
	}
	
	public static void moveBlocks(int sc, int ec) { // 파란색 블록들 이동
		for(int c = sc; c > ec; c--) {
			for(int r = 0; r < 4; r++)
				blue[r][c] = blue[r][c - 1];
		}
		
		for(int r = 0; r < 4; r++)
			blue[r][ec] = 0;
	}
	
	public static void moveBlocksG(int sr, int er) { // 초록색 블록들 이동
		for(int r = sr; r > er; r--) {
			for(int c = 0; c < 4; c++)
				green[r][c] = green[r - 1][c];
		}
		
		for(int c = 0; c < 4; c++)
			green[er][c] = 0;
	}
}