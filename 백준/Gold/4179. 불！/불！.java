import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Position{
	int r, c, time;
	
	public Position(int r, int c) {
		this.r = r;
		this.c = c;
	}
	
	public Position(int r, int c, int time) {
		this.r = r;
		this.c = c;
		this.time = time;
	}
}

public class Main {
	public static int[] dr = {-1, 1, 0, 0};
	public static int[] dc = {0, 0, -1, 1};
	
	public static Queue<Position> jihoon;
	public static Queue<Position> fire;
	
	public static char[][] maze;
	public static int R, C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		maze = new char[R][C];
		jihoon = new ArrayDeque<>();
		fire = new ArrayDeque<>();
		
		for(int r = 0; r < R; r++) {
			String str = br.readLine();
			for(int c = 0; c < C; c++) {
				maze[r][c] = str.charAt(c);
				if(maze[r][c] == 'J')
					jihoon.offer(new Position(r, c, 0));
				else if(maze[r][c] == 'F')
					fire.offer(new Position(r, c));
			}
		}
		
		int result = spread();
		
		if(result == -1)
			System.out.println("IMPOSSIBLE");
		else
			System.out.println(result);
	}
	
	public static int spread() {
		while(!jihoon.isEmpty()) {
			int size = fire.size();
			while(size-- > 0) {
				// 불 이동
				Position cur = fire.poll();
				
				for(int d = 0; d < 4; d++) {
					int nr = cur.r + dr[d];
					int nc = cur.c + dc[d];
					
					if(nr < 0 || nr >= R || nc < 0 || nc >= C)
						continue;
					
					if(maze[nr][nc] == '.' || maze[nr][nc] == 'J') {
						maze[nr][nc] = 'F';
						fire.offer(new Position(nr, nc));
					}
				}
			}
			
			// 지훈 이동
			size = jihoon.size();
			
			while(size-- > 0) {
				Position cur = jihoon.poll();
				
				for(int d = 0; d < 4; d++) {
					int nr = cur.r + dr[d];
					int nc = cur.c + dc[d];
					
					if(nr < 0 || nr >= R || nc < 0 || nc >= C)
						return cur.time + 1;
					
					if(maze[nr][nc] == '.') {
						maze[nr][nc] = 'J';
						jihoon.offer(new Position(nr, nc, cur.time + 1));
					}
				}
			}	
		}
		
		return -1;
	}
}