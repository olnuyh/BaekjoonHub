import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	public static int[] dr = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
	public static int[] dc = {-1, 0, 1, -1, 0, 1, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[][] chess = new char[8][8];

		Queue<int []> character = new ArrayDeque<>();
		Queue<int []> wall = new ArrayDeque<>();
		
		for(int i = 0; i < 8; i++) {
			String str = br.readLine();
			for(int j = 0; j < 8; j++)
				chess[i][j] = str.charAt(j);
		}
		
		for(int i = 7; i >= 0; i--) {
			for(int j = 0; j < 8; j++) {
				if(chess[i][j] == '#')
					wall.offer(new int[] {i, j});
			}
		}
		
		character.offer(new int[] {7, 0});
		boolean[][] visited;
		
		int isPossible = 0;
		
		while(!character.isEmpty()) {
			// 욱제 이동
			int size = character.size();
			visited = new boolean[8][8];
			
			while(--size >= 0) {
				int[] now = character.poll();
				
				if(now[0] == 0 && now[1] == 7) {
					isPossible = 1;
					character.clear();
					break;
				}
				
				if(chess[now[0]][now[1]] == '#') continue;
				else character.offer(new int[] {now[0], now[1]});
				
				for(int i = 0; i < 9; i++) {
					int nr = now[0] + dr[i];
					int nc = now[1] + dc[i];
					
					if(nr < 0 || nr >= 8 || nc < 0 || nc >= 8) continue;
					
					if(!visited[nr][nc] && chess[nr][nc] == '.') {
						visited[nr][nc] = true;
						character.offer(new int[] {nr, nc});
					}
				}
			}
			
			// 벽 이동
			size = wall.size();
			while(--size >= 0) {
				int[] now = wall.poll();
				chess[now[0]][now[1]] = '.';
				
				if(now[0] + 1 == 8) continue;
				
				chess[now[0] + 1][now[1]] = '#';
				wall.offer(new int[] {now[0] + 1, now[1]});
			}
		}
		
		System.out.println(isPossible);
	}

}