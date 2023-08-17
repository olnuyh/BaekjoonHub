import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static int h, w;
	public static int[] dr = {-1, 1, 0, 0};
	public static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			char[][] map = new char[h][];
			
			int[] tank = new int[2];
			
			for(int i = 0; i < h; i++) {
				map[i] = br.readLine().toCharArray();
				for(int j = 0; j < w; j++) {
					if("^v<>".indexOf(map[i][j]) >= 0) {
						tank[0] = i;
						tank[1] = j;
					}
				}
			}
			
			int n = Integer.parseInt(br.readLine());
			
			char[] command = new char[n];
			String temp = br.readLine();
			
			for(int i = 0; i < n; i++)
				command[i] = temp.charAt(i);
			
			for(int i = 0; i < n; i++) {
				int nr, nc;
				switch (command[i]) {
				case 'U':
					nr = tank[0] - 1;
					nc = tank[1];
					
					if(isIn(nr, nc) && map[nr][nc] == '.') {
						map[nr][nc] = '^';
						map[tank[0]][tank[1]] = '.';
						tank[0] = nr;
						tank[1] = nc;
					}else
						map[tank[0]][tank[1]] = '^';
					break;

				case 'D':
					nr = tank[0] + 1;
					nc = tank[1];
					
					if(isIn(nr, nc) && map[nr][nc] == '.') {
						map[nr][nc] = 'v';
						map[tank[0]][tank[1]] = '.';
						tank[0] = nr;
						tank[1] = nc;
					}else
						map[tank[0]][tank[1]] = 'v';
					break;
					
				case 'L':
					nr = tank[0];
					nc = tank[1] - 1;
					
					if(isIn(nr, nc) && map[nr][nc] == '.') {
						map[nr][nc] = '<';
						map[tank[0]][tank[1]] = '.';
						tank[0] = nr;
						tank[1] = nc;
					}else
						map[tank[0]][tank[1]] = '<';
					break;
					
				case 'R':
					nr = tank[0];
					nc = tank[1] + 1;
					
					if(isIn(nr, nc) && map[nr][nc] == '.') {
						map[nr][nc] = '>';
						map[tank[0]][tank[1]] = '.';
						tank[0] = nr;
						tank[1] = nc;
					}else
						map[tank[0]][tank[1]] = '>';
					break;
					
				case 'S':
					int d = "^v<>".indexOf(map[tank[0]][tank[1]]);
					
					for(int l = 1; ; l++) {
						nr = tank[0] + dr[d] * l;
						nc = tank[1] + dc[d] * l;
						
						if(!isIn(nr, nc) || map[nr][nc] == '#')
							break;
						
						if(map[nr][nc] == '*') {
							map[nr][nc] = '.';
							break;
						}
					}
					break;
				}
			}
			
			sb.append("#").append(tc).append(" ");
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++)
					sb.append(map[i][j]);
				sb.append("\n");
			}
		}
		
		System.out.println(sb);
	}
	
	public static boolean isIn(int r, int c) {
		if(r < 0 || r >= h || c < 0 || c >= w)
			return false;
		return true;
	}

}