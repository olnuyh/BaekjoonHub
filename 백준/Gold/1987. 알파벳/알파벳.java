import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int r, c;
	public static int[] dr = {-1, 1, 0, 0};
	public static int[] dc = {0, 0, -1, 1};
	public static int[][] board;
	public static boolean[] visited;
	public static int maxMove;
	
	public static void dfs(int sr, int sc, int cnt) {
		for(int i = 0; i < 4; i++) {
			int nr = sr + dr[i];
			int nc = sc + dc[i];
			
			if(nr < 0 || nr >= r || nc < 0 || nc >= c) continue;
			
			if(visited[board[nr][nc]]) continue;
			
			visited[board[nr][nc]] = true;
			dfs(nr, nc, cnt + 1);
			visited[board[nr][nc]] = false;
		}
		
		maxMove = Math.max(maxMove, cnt);
		return;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		board = new int[r][c];
		
		for(int i = 0; i < r; i++) {
			String str = br.readLine();
			for(int j = 0; j < c; j++)
				board[i][j] = str.charAt(j) - 'A';
		}
		
		visited = new boolean[26];
		visited[board[0][0]] = true;
		maxMove = 1;
		dfs(0, 0, 1);
		System.out.println(maxMove);
	}

}