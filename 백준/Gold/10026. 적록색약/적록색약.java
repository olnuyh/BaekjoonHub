import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int n;
	public static char[][] painting;
	public static boolean[][] visited;
	public static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void dfsNo(int r, int c, char color) {
		visited[r][c] = true;
		
		for(int i = 0; i < 4; i++) {
			int nr = r + deltas[i][0];
			int nc = c + deltas[i][1];
			
			if(nr < 0 || nr >= n || nc < 0 || nc >= n)
				continue;
			
			if(!visited[nr][nc] && painting[nr][nc] == color)
				dfsNo(nr, nc, color);
		}
	}
	
	public static void dfsYes(int r, int c, char color) {
		visited[r][c] = true;
		
		for(int i = 0; i < 4; i++) {
			int nr = r + deltas[i][0];
			int nc = c + deltas[i][1];
			
			if(nr < 0 || nr >= n || nc < 0 || nc >= n)
				continue;
			
			if(!visited[nr][nc]) {
				if(color == 'B' && painting[nr][nc] == color)
					dfsYes(nr, nc, color);
				else if(color != 'B' && painting[nr][nc] != 'B')
					dfsYes(nr, nc, painting[nr][nc]);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		painting = new char[n][n];
		
		for(int i = 0; i < n; i++)
			painting[i] = br.readLine().toCharArray();
		
		visited = new boolean[n][n];
		int cntNo = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(!visited[i][j]) {
					dfsNo(i, j, painting[i][j]);
					cntNo++;
				}
					
			}
		}
		
		visited = new boolean[n][n];
		int cntYes = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(!visited[i][j]) {
					dfsYes(i, j, painting[i][j]);
					cntYes++;
				}
					
			}
		}
		
		System.out.println(cntNo + " " + cntYes);
	}

}