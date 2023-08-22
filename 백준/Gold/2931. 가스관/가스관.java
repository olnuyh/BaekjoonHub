import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[] dr = {-1, 1, 0, 0};
	public static int[] dc = {0, 0, -1, 1};
	
	public static char[][] map;
	public static int[] start;
	public static int[] end;
	
	public static int d;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		map = new char[r][];
		
		start = new int[2];
		end = new int[2];
		
		for(int i = 0; i < r; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j = 0; j < c; j++) {
				if(map[i][j] == 'M') {
					start[0] = i;
					start[1] = j;
				}else if(map[i][j] == 'Z') {
					end[0] = i;
					end[1] = j;
				}
			}
		}
		
		for(int i = 0; i < 4; i++) {
			int nr = start[0] + dr[i];
			int nc = start[1] + dc[i];
			
			if(nr < 0 || nr >= r || nc < 0 || nc >= c) continue;
			
			if(map[nr][nc] != '.' && map[nr][nc] != 'Z') {
				d = i;
				start[0] = nr;
				start[1] = nc;
				break;
			}
		}
		
		check(start[0], start[1]);
		
		boolean[] pipeCheck = new boolean[4];

		if(start[0] >= 1 && "|+14".indexOf(map[start[0] - 1][start[1]]) >= 0)
			pipeCheck[0] = true;
		
		if(start[0] < r - 1 && "|+23".indexOf(map[start[0] + 1][start[1]]) >= 0)
			pipeCheck[1] = true;
		
		if(start[1] >= 1 && "-+12".indexOf(map[start[0]][start[1] - 1]) >= 0)
			pipeCheck[2] = true;
		
		if(start[1] < c - 1 && "-+34".indexOf(map[start[0]][start[1] + 1]) >= 0)
			pipeCheck[3] = true;
		
		int flagM = -1;
		int flagZ = -1;
		
		for(int i = 0; i < 4; i++) {
			int nr = start[0] + dr[i];
			int nc = start[1] + dc[i];
			
			if(nr < 0 || nr >= r || nc < 0 || nc >= c) continue;
			
			if(map[nr][nc] == 'M')
				flagM = i;
			else if(map[nr][nc] == 'Z')
				flagZ = i;
		} 
		
		if(flagM != -1 && flagZ == -1)
			pipeCheck[flagM] = true;
		else if(flagM == -1 && flagZ != -1)
			pipeCheck[flagZ] = true;
		
		char blank = setPipe(pipeCheck);
	
		sb.append(start[0] + 1).append(" ").append(start[1] + 1).append(" ").append(blank);

		System.out.println(sb);
	}
	
	public static void check(int r, int c) {
		while(!(r == end[0] && c == end[1])) {
			switch (map[r][c]) {
			case '|':
				if(map[r + dr[d]][c] == '.') {
					start[0] = r + dr[d];
					start[1] = c;
					return;
				}
				break;

			case '-':
				if(map[r][c + dc[d]] == '.') {
					start[0] = r;
					start[1] = c + dc[d];
					return;
				}
				break;
				
			case '+':
				for(int i = 0; i < 4; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					
					if(map[nr][nc] == '.') {
						start[0] = nr;
						start[1] = nc;
						return;
					}
				}
				break;
				
			case '1':
				if(d == 2) {
					if(map[r + 1][c] == '.') {
						start[0] = r + 1;
						start[1] = c;
						return;
					}
				}else if(d == 0) {
					if(map[r][c + 1] == '.') {
						start[0] = r;
						start[1] = c + 1;
						return;
					}
				}
				
				if(d == 2)
					d = 1;
				else if(d == 0)
					d = 3;
				
				break;
				
			case '2':
				if(d == 1) {
					if(map[r][c + 1] == '.') {
						start[0] = r;
						start[1] = c + 1;
						return;
					}
				}else if(d == 2) {
					if(map[r - 1][c] == '.') {
						start[0] = r - 1;
						start[1] = c;
						return;
					}
				}
				
				if(d == 1)
					d = 3;
				else if(d == 2)
					d = 0;
				
				break;
				
			case '3':
				if(d == 1) {
					if(map[r][c - 1] == '.') {
						start[0] = r;
						start[1] = c - 1;
						return;
					}
				}else if(d == 3) {
					if(map[r - 1][c] == '.') {
						start[0] = r - 1;
						start[1] = c;
						return;
					}
				}
				
				if(d == 1)
					d = 2;
				else if(d == 3)
					d = 0;
				
				break;
				
			case '4':
				if(d == 3) {
					if(map[r + 1][c] == '.') {
						start[0] = r + 1;
						start[1] = c;
						return;
					}
				}else if(d == 0) {
					if(map[r][c - 1] == '.') {
						start[0] = r;
						start[1] = c - 1;
						return;
					}
				}
				
				if(d == 3)
					d = 1;
				else if(d == 0)
					d = 2;
				
				break;
			}
			
			r += dr[d];
			c += dc[d];
		}
	}

	public static char setPipe(boolean[] pipeCheck) {
		if(pipeCheck[0] && pipeCheck[1] && pipeCheck[2] && pipeCheck[3])
			return '+';
		
		if(pipeCheck[0] && pipeCheck[1])
			return '|';
		
		if(pipeCheck[2] && pipeCheck[3])
			return '-';
		
		if(pipeCheck[1] && pipeCheck[3])
			return '1';
		
		if(pipeCheck[0] && pipeCheck[3])
			return '2';
		
		if(pipeCheck[2] && pipeCheck[0])
			return '3';
		
		if(pipeCheck[2] && pipeCheck[1])
			return '4';
		
		return ' ';
	}
}