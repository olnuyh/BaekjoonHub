import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Position{
	int r, c, time;
	
	Position(int r, int c){
		this.r = r;
		this.c = c;
	}
	
	Position(int r, int c, int time){
		this.r = r;
		this.c = c;
		this.time = time;
	}
}

public class Main {
	public static int r, c;
	public static int[] dr = {-1, 1, 0, 0};
	public static int[] dc = {0, 0, -1, 1};
	public static Queue<Position> hedgehog;
	public static Queue<Position> water;
	public static char[][] map;
	public static int minTime;

	public static void move() {
		while(!hedgehog.isEmpty()) {
			int size = water.size();
			
			// 물 이동
			while(--size >= 0) {
				Position now = water.poll();
				
				for(int i = 0; i < 4; i++) {
					int nr = now.r + dr[i];
					int nc = now.c + dc[i];
					
					if(nr < 0 || nr >= r || nc < 0 || nc >= c) continue;
					
					if(map[nr][nc] == '.' || map[nr][nc] == 'S') {
						map[nr][nc] = '*';
						water.offer(new Position(nr, nc));
					}
				}
			}
			
			// 고슴도치 이동
			size = hedgehog.size();
			while(--size >= 0) {
				Position now = hedgehog.poll();
				
				for(int i = 0; i < 4; i++) {
					int nr = now.r + dr[i];
					int nc = now.c + dc[i];
					
					if(nr < 0 || nr >= r || nc < 0 || nc >= c) continue;
					
					if(map[nr][nc] == 'D') {
						minTime = now.time + 1;
						return;
					}else if(map[nr][nc] == '.') {
						map[nr][nc] = 'S';
						hedgehog.offer(new Position(nr, nc, now.time + 1));
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new char[r][c];
		hedgehog = new ArrayDeque<>();
		water = new ArrayDeque<>();
		
		for(int i = 0; i < r; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j = 0; j < c; j++) {
				if(map[i][j] == 'S')
					hedgehog.offer(new Position(i, j, 0));
				else if(map[i][j] == '*')
					water.offer(new Position(i, j));
			}
		}
		
		minTime = 0;
		move();
		
		if(minTime == 0)
			System.out.println("KAKTUS");
		else
			System.out.println(minTime);
	}

}