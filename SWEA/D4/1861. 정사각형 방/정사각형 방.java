import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static int[] dr = {-1, 1, 0, 0};
	public static int[] dc = {0, 0, -1, 1};
	public static int n;
	public static int cnt;
	public static int[][] room;
	public static boolean[][] visited;
	
	public static void dfs(int r, int c) {
		visited[r][c] = true;
		cnt++;
		
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
			
			if(room[nr][nc] - room[r][c] == 1)
				dfs(nr, nc);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			
			room = new int[n][n];
			visited = new boolean[n][n];
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++)
					room[i][j] = Integer.parseInt(st.nextToken());
			}
			
			int minNum = Integer.MAX_VALUE;
			int maxRoom = Integer.MIN_VALUE;
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					
					if(!visited[i][j]) {
						cnt = 0;
						dfs(i, j);
					}
					
					if(cnt > maxRoom) {
						maxRoom = cnt;
						minNum = room[i][j];
					}else if(cnt == maxRoom)
						minNum = Math.min(minNum, room[i][j]);
				}
			}
			
			sb.append("#").append(tc).append(" ").append(minNum).append(" ").append(maxRoom).append("\n");
		}
		
		System.out.println(sb);
	}

}