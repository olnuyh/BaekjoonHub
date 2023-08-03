import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		char[][] grid = new char[r][c];
		int[][] time = new int[r][c];
		
		for(int i = 0; i < r; i++) {
			grid[i] = br.readLine().toCharArray();
			for(int j = 0; j < c; j++) {
				if(grid[i][j] == 'O')
					time[i][j] = 0;
				else
					time[i][j] = 1;
			}
		}
		
		for(int t = 2; t <= n; t++) {
			if(t % 2 == 0) { // 폭탄 없는 모든 칸에 폭탄 설치
				for(int i = 0; i < r; i++) {
					for(int j = 0; j < c; j++) {
						if(grid[i][j] == '.') {
							grid[i][j] = 'O';
							time[i][j] = t;
						}
					}
				}
			}else { // 폭탄 모두 폭발
				Queue<int []> q = new LinkedList<>();
				
				for(int i = 0; i < r; i++) {
					for(int j = 0; j < c; j++) {
						if(grid[i][j] == 'O' && time[i][j] == t - 3)
							q.add(new int[] {i, j});
					}
				}
				
				while(!q.isEmpty()) {
					int[] bomb = q.poll();
					grid[bomb[0]][bomb[1]] = '.';
					time[bomb[0]][bomb[1]] = 0;
					
					for(int i = 0; i < 4; i++) {
						int nr = bomb[0] + dr[i];
						int nc = bomb[1] + dc[i];
						
						if(nr < 0 || nr >= r || nc < 0 || nc >= c) continue;
						
						if(grid[nr][nc] == 'O')
							time[nr][nc] = 0;
						
						grid[nr][nc] = '.';
					}
				}
			}
		}
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++)
				sb.append(grid[i][j]);
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}