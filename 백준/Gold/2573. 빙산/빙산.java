import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class IceBerg{
	int r, c, meltCnt;
	
	public IceBerg(int r, int c, int meltCnt) {
		this.r = r;
		this.c = c;
		this.meltCnt = meltCnt;
	}
}

public class Main {
	public static int[] dr = {-1, 1, 0, 0};
	public static int[] dc = {0, 0, -1, 1};
	public static int[][] northPole;
	public static int N, M;
	public static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		northPole = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++)
				northPole[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int year = 0;
		while(true) {
			year++;
			
			melt();
			
			visited = new boolean[N][M];
			int mass = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(northPole[i][j] > 0 && !visited[i][j]) {
						check(i, j);
						mass++;
					}
				}
			}
			
			if(mass == 0) {
				year = 0;
				break;
			}else if(mass >= 2)
				break;
		}
		
		System.out.println(year);
	}
	
	public static void melt() {
		ArrayList<IceBerg> list = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(northPole[i][j] > 0) {
					int cnt = 0;
					for(int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						
						if(isIn(nr, nc) && northPole[nr][nc] == 0)
							cnt++;
					}
					
					list.add(new IceBerg(i, j, cnt));
				}
			}
		}
		
		for(IceBerg ib : list) {
			int newV = northPole[ib.r][ib.c] - ib.meltCnt;
			if(newV < 0)
				northPole[ib.r][ib.c] = 0;
			else
				northPole[ib.r][ib.c] = newV;
		}
	}
	
	public static void check(int r, int c) {
		visited[r][c] = true;
		
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(isIn(nr, nc) && !visited[nr][nc] && northPole[nr][nc] > 0)
				check(nr, nc);
		}
	}
	
	public static boolean isIn(int r, int c) {
		if(r < 0 || r >= N || c < 0 || c >= M)
			return false;
		return true;
	}
}