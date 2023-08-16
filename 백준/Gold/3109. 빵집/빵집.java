import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int r, c;
	public static int[] dr = {-1, 0, 1};
	public static char[][] map;
	public static boolean[][] visited;
	public static int pipeline;
	
	public static void dfs(int sr, int sc) {
		visited[sr][sc] = true;
		
		if(sc == c - 1) {		
			pipeline++;
			return;
		}
		
		int cnt = pipeline;
		
		for(int i = 0; i < 3; i++) {
			int nr = sr + dr[i];
			int nc = sc + 1;
			
			if(nr < 0 || nr >= r || nc < 0 || nc >= c) continue;
			
			if(cnt != pipeline) return;
			
			if(!visited[nr][nc] && map[nr][nc] == '.') 
				dfs(nr, nc);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new char[r][c];
		
		for(int i = 0; i < r; i++) {
			String temp = br.readLine();
			for(int j = 0; j < c; j++)
				map[i][j] = temp.charAt(j);
		}
		
		visited = new boolean[r][c];
		pipeline = 0;
		
		for(int i = 0; i < r; i++)
			dfs(i, 0);

		
		System.out.println(pipeline);
	}

}