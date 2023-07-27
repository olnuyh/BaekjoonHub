import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos{
	int r;
	int c;
	
	Pos(int r, int c){
		this.r = r;
		this.c = c;
	}
}

public class Main {
	public static int r, c;
	public static int[] dr = {-1, 1, 0, 0};
	public static int[] dc = {0, 0, -1, 1};
	public static int[][] visited;
	public static char[][] map;
	
	public static int bfs(int startR, int startC) {
		Queue<Pos> q = new LinkedList<>();
		
		q.add(new Pos(startR, startC));
		visited[startR][startC] = 1;
		
		while(!q.isEmpty()) {
			Pos now = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nr = now.r + dr[i];
				int nc = now.c + dc[i];
				
				if(nr < 0 || nr >= r || nc < 0 || nc >= c)
					continue;
				
				if(visited[nr][nc] == 0) {
					if(map[nr][nc] == 'L') {
						q.add(new Pos(nr, nc));
						visited[nr][nc] = visited[now.r][now.c] + 1;
					}
				}
			}
		}
		
		int max = 0;
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++)
				max = Math.max(max, visited[i][j]);
				
		}
		
			return max - 1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new char[r][c];
		
		for(int i = 0; i < r; i++) 
			map[i] = br.readLine().toCharArray();
		
		int answer = 0;
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(map[i][j] == 'L') {
					visited = new int[r][c];
					answer = Math.max(answer, bfs(i, j));
				}
			}
		}
		
		System.out.println(answer);
	}

}