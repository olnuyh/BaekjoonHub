import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int r, c;
	public static int maxMove;
	public static char[][] alphabets;
	public static int[] dr = {-1, 1, 0, 0};
	public static int[] dc = {0, 0, -1, 1};
	public static boolean[] isIn;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		alphabets = new char[r][];
		
		for(int i = 0; i < r; i++)
			alphabets[i] = br.readLine().toCharArray();
		
		maxMove = Integer.MIN_VALUE;
		isIn = new boolean[26];
		isIn[alphabets[0][0] - 'A'] = true;
		
		dfs(0, 0, 1);
		System.out.println(maxMove);
	}
	
	public static void dfs(int sr, int sc, int cnt) {
		for(int i = 0; i < 4; i++) {
			int nr = sr + dr[i];
			int nc = sc + dc[i];
			
			if(nr < 0 || nr >= r || nc < 0 || nc >= c) continue;
			
			if(isIn[alphabets[nr][nc] - 'A']) continue;
			
			isIn[alphabets[nr][nc] - 'A'] = true;
			dfs(nr, nc, cnt + 1);
			isIn[alphabets[nr][nc] - 'A'] = false;
		}
		
		maxMove = Math.max(maxMove, cnt);
		return;
	}

}