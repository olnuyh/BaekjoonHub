import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int n;
	public static int[][] house;
	public static int[] dr = {0, 1, 1};
	public static int[] dc = {1, 1, 0};
	public static int cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		house = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++)
				house[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int[] pipe = {0, 1};
		
		cnt = 0;
		dfs(pipe[0], pipe[1], 0);
		
		System.out.println(cnt);
	}
	
	public static void dfs(int r, int c, int d) {
		//System.out.println(r + ": " + c);
		if(r == n - 1 && c == n - 1) {
			cnt++;
			return;
		}
		
		if(d == 0) {
			if(isIn(r, c + 1) && house[r][c + 1] == 0)
				dfs(r, c + 1, 0);
			
			if(isIn(r + 1, c + 1) && house[r + 1][c] == 0 && house[r][c + 1] == 0 && house[r + 1][c + 1] == 0)
				dfs(r + 1, c + 1, 2);
		}else if(d == 1) {
			if(isIn(r + 1, c) && house[r + 1][c] == 0)
				dfs(r + 1, c, 1);
			
			if(isIn(r + 1, c + 1) && house[r + 1][c] == 0 && house[r][c + 1] == 0 && house[r + 1][c + 1] == 0)
				dfs(r + 1, c + 1, 2);
			
		}else if(d == 2) {
			if(isIn(r, c + 1) && house[r][c + 1] == 0)
				dfs(r, c + 1, 0);
			
			if(isIn(r + 1, c + 1) && house[r + 1][c] == 0 && house[r][c + 1] == 0 && house[r + 1][c + 1] == 0)
				dfs(r + 1, c + 1, 2);
			
			if(isIn(r + 1, c) && house[r + 1][c] == 0)
				dfs(r + 1, c, 1);
		}
	}
	
	public static boolean isIn(int r, int c) {
		if(r < 0 || r >= n || c < 0 || c >= n)
			return false;
		return true;
	}
}