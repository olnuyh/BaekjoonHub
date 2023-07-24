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
	public static int[][] deltas2 = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
	
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
		q.add(new Cloud(n - 1, 0));
		q.add(new Cloud(n - 1, 1));
		q.add(new Cloud(n - 2, 0));
		q.add(new Cloud(n - 2, 1));
		
		for(int i = 0; i < m; i++) {
			boolean[][] cloudPos = new boolean[n][n];
			int size = q.size();
			
			int d = move[i][0] - 1;
			int l = move[i][1];
			
			for(int j = 0; j < q.size(); j++) {
				Cloud now = q.poll();
				
				int r = now.r;
				int c = now.c;
				
				for(int k = 0; k < l; k++) {
					r += deltas[d][0];
					c += deltas[d][1];
					
					if(r < 0)
						r += n;
					else if(r >= n)
						r -= n;
					
					if(c < 0)
						c += n;
					else if(c >= n)
						c -= n;
				}
				
				q.add(new Cloud(r, c));
			}
			
			for(int j = 0; j < size; j++) {
				Cloud now = q.poll();
				cloudPos[now.r][now.c] = true;
				grid[now.r][now.c] += 1;
				q.add(now);
			}
			
			while(!q.isEmpty()) {
				Cloud now = q.poll();
				int cnt = 0;
				for(int j = 0; j < 4; j++) {
					int nr = now.r + deltas2[j][0];
					int nc = now.c + deltas2[j][1];
					
					if(nr < 0 || nr >= n || nc < 0 || nc >= n)
						continue;
					
					if(grid[nr][nc] > 0)
						cnt++;
				}
				
				grid[now.r][now.c] += cnt;
			}
			
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < n; k++) {
					if(grid[j][k] >= 2 && !cloudPos[j][k]) {
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