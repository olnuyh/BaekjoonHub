import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

class Virus{
	int r, c;
	
	public Virus(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class Main {
	public static int[][] lab;
	public static int[][] copyLab;
	public static int n, m;
	public static int[] dr = {-1, 1, 0, 0};
	public static int[] dc = {0, 0, -1, 1};
	public static ArrayList<Virus> virusList;
	public static int minTime;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		lab = new int[n][n];
		
		virusList = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				lab[i][j] = Integer.parseInt(st.nextToken());
				if(lab[i][j] == 2) {
					virusList.add(new Virus(i, j));
					lab[i][j] = 0;
				}
			}
		}
		
		minTime = Integer.MAX_VALUE;
		putVirus(0, 0, new int[m]);
		
		if(minTime == Integer.MAX_VALUE)
			minTime = -1;
		
		System.out.println(minTime);
	}
	
	public static void putVirus(int cnt, int start, int[] selected) {
		if(cnt == m) {			
			copyLab = new int[n][n];
			for(int i = 0; i < n; i++)
				copyLab[i] = Arrays.copyOf(lab[i], lab[i].length);
			
			for(int i = 0; i < m; i++) {
				Virus v = virusList.get(selected[i]);
				copyLab[v.r][v.c] = 2;
			}
			
			int time = bfs();
			minTime = Math.min(minTime, time);
		
			return;
		}
		
		for(int i = start; i < virusList.size(); i++) {
			selected[cnt] = i;
			putVirus(cnt + 1, i + 1, selected);
		}
	}

	public static int bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		int[][] visited = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(copyLab[i][j] == 2) {
					q.add(new int[] {i, j});
					visited[i][j] = 0;
				}else if(copyLab[i][j] == 1)
					visited[i][j] = -1;
			}
		}
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				
				if(nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
				
				if(copyLab[nr][nc] == 0 && visited[nr][nc] == 0) {
					q.add(new int[] {nr, nc});
					visited[nr][nc] = visited[cur[0]][cur[1]] + 1;
				}
			}
			
		}
		
		int result = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(copyLab[i][j] == 0 && visited[i][j] == 0)
					return Integer.MAX_VALUE;
				
				result = Math.max(result, visited[i][j]);
			}
		}

		return result;
	}
}