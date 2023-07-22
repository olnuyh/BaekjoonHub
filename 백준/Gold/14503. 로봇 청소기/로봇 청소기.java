import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int n, m, d;
	public static int[] dr = {-1, 0, 1, 0};
	public static int[] dc = {0, 1, 0, -1};
	
	public static int[][] room;
	public static int cnt = 0;

	public static void clean(int r, int c) {
		if(room[r][c] == 0) {
			cnt++;
			room[r][c] = 2;
		}
		
		boolean isAllClean = true;
		
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr >= 0 && nr < n && nc >= 0 && nc < m && room[nr][nc] == 0) {
				isAllClean = false;
				break;
			}
		}
		
		if(isAllClean) {
			int nr = r + dr[(d + 2) % 4];
			int nc = c + dc[(d + 2) % 4];
			
			if(nr >= 0 && nr < n && nc >= 0 && nc < m && room[nr][nc] != 1) {
				clean(nr, nc);
			}
			else {
				return;
			}
		}
		else {
			d = (d + 3) % 4;
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr >= 0 && nr < n && nc >= 0 && nc < m && room[nr][nc] == 0) {
				clean(nr, nc);
			}
			else
				clean(r, c);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());
		
		int[] cleaner = new int[2];
		stk = new StringTokenizer(br.readLine());
		cleaner[0] = Integer.parseInt(stk.nextToken());
		cleaner[1] = Integer.parseInt(stk.nextToken());
		
		d = Integer.parseInt(stk.nextToken());
		
		room = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			stk = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++)
				room[i][j] = Integer.parseInt(stk.nextToken());
		}
		
		clean(cleaner[0], cleaner[1]);

		System.out.println(cnt);
	}

}