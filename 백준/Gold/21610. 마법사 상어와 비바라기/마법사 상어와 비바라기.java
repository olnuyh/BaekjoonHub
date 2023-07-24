import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Cloud{
	int r;
	int c;
	
	Cloud(int r, int c){
		this.r = r;
		this.c = c;
	}
}

public class Main {
	public static int[][] deltas = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] grid = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++)
				grid[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int[][] move = new int[m][2];
		
		for(int i = 0; i < m; i++){
			st = new StringTokenizer(br.readLine());
			move[i][0] = Integer.parseInt(st.nextToken());
			move[i][1] = Integer.parseInt(st.nextToken());
		}
			
		Queue<Cloud> q = new LinkedList<>();
		q.add(new Cloud(n - 1, 0)); // 처음 생성된 비구름
		q.add(new Cloud(n - 1, 1));
		q.add(new Cloud(n - 2, 0));
		q.add(new Cloud(n - 2, 1));
		
		for(int i = 0; i < m; i++) {
			boolean[][] cloudPos = new boolean[n][n];
			int size = q.size();
			
			int d = move[i][0] - 1;
			int l = move[i][1];
			
			for(Cloud cloud : q) { // 구름 위치 이동, 구름 칸 물의 양 1 증가
				cloud.r = (n + cloud.r + deltas[d][0] * (move[i][1] % n)) % n;
				cloud.c = (n + cloud.c + deltas[d][1] * (move[i][1] % n)) % n;
				
				cloudPos[cloud.r][cloud.c] = true;
				grid[cloud.r][cloud.c]++;
			}
			
			while(!q.isEmpty()) { // 물복사버그 마법
				Cloud now = q.poll();
				int cnt = 0;
				for(int j = 1; j < 8; j += 2) {
					int nr = now.r + deltas[j][0];
					int nc = now.c + deltas[j][1];
					
					if(nr < 0 || nr >= n || nc < 0 || nc >= n)
						continue;
					
					if(grid[nr][nc] > 0)
						cnt++;
				}
				
				grid[now.r][now.c] += cnt;
			}
			
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < n; k++) {
					if(!cloudPos[j][k] && grid[j][k] >= 2) {
						q.add(new Cloud(j, k));
						grid[j][k] -= 2;
					}
				}
			}
			
		}
		
		int water = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++){
				water += grid[i][j];
			}
		}
		
		System.out.println(water);
	}

}