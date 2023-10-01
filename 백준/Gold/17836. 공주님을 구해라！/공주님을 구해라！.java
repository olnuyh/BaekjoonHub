import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Soldier{
	int r, c, time;
	int weapon; // 0이면 그람 없음, 1이면 그람 있음

	public Soldier(int r, int c, int time, int weapon) {
		this.r = r;
		this.c = c;
		this.time = time;
		this.weapon = weapon;
	}
}

public class Main {
	public static int N, M;
	public static int[][] castle;
	public static int[] dr = {-1, 1, 0, 0};
	public static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		castle = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++)
				castle[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int time = move();
		
		if(time == -1 || time > T)
			System.out.println("Fail");
		else
			System.out.println(time);
	}
	
	public static int move() {
		Queue<Soldier> q = new ArrayDeque<>();
		q.offer(new Soldier(0, 0, 0, 0));
		boolean[][][] visited = new boolean[N][M][2];
		visited[0][0][0] = true;
		
		while(!q.isEmpty()) {
			Soldier s = q.poll();
			
			if(s.r == N - 1 && s.c == M - 1)
				return s.time;
			
			for(int i = 0; i < 4; i++) {
				int nr = s.r + dr[i];
				int nc = s.c + dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				
				if(s.weapon == 1) { // 그람이 있는 경우
					if(!visited[nr][nc][s.weapon]) {
						q.offer(new Soldier(nr, nc, s.time + 1, s.weapon));
						visited[nr][nc][s.weapon] = true;
					}
				}else { // 그람이 없는 경우
					if(castle[nr][nc] == 1) continue;
					
					if(castle[nr][nc] == 2) {
						if(!visited[nr][nc][1]) {
							q.offer(new Soldier(nr, nc, s.time + 1, 1));
							visited[nr][nc][1] = true;
						}
					}
					else {
						if(!visited[nr][nc][s.weapon]) {
							q.offer(new Soldier(nr, nc, s.time + 1, s.weapon));
							visited[nr][nc][s.weapon] = true;
						}
					}
				}
			}
		}
		return -1;
	}
}