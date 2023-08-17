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
	public static int pipeline;
	
	public static boolean dfs(int sr, int sc) {		
		if(sc == c - 1) {		
			pipeline++;
			return true;
		}
		
		for(int i = 0; i < 3; i++) {
			int nr = sr + dr[i];
			int nc = sc + 1;
			
			if(nr < 0 || nr >= r || nc < 0 || nc >= c) continue;
			
			if(map[nr][nc] == 'x') continue;
			
			map[nr][nc] = 'x';

			if(dfs(nr, nc)) return true;
		}
		
		return false;
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
		
		pipeline = 0;
		
		for(int i = 0; i < r; i++)
			dfs(i, 0);

		
		System.out.println(pipeline);
	}

}