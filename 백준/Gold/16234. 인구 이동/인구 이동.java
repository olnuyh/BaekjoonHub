import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, l, r;
	static int[][] ground;
	static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static boolean[][] visited;
	static int check;
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static void bfs(int startR, int startC) {
		Queue<int[]> q = new LinkedList<>();
		int[] start = new int[] {startR, startC};
		q.add(start);
		visited[startR][startC] = true;
		
		int cnt = 1;
		int population = ground[startR][startC];
		
		ArrayList<int[]> list = new ArrayList<>();
		list.add(start);
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nr = now[0] + deltas[i][0];
				int nc = now[1] + deltas[i][1];
				
				if(nr < 0 || nr >= n || nc < 0 || nc >= n)
					continue;
				
				if(!visited[nr][nc] && Math.abs(ground[now[0]][now[1]] - ground[nr][nc]) >= l && Math.abs(ground[now[0]][now[1]] - ground[nr][nc]) <= r) {
					visited[nr][nc] = true;
					int[] next = new int[] {nr, nc};
					q.add(next);
					list.add(next);
					
					cnt++;
					population += ground[nr][nc];
				}
			}
		}
		
		if(cnt == 1)
			return;
		
		check++;
		
		for(int i = 0; i < list.size(); i++) {
			ground[list.get(i)[0]][list.get(i)[1]] = population / cnt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		ground = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++)
				ground[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int day = 0;
		
		while(true) {
			visited = new boolean[n][n];
			check = 0;
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(!visited[i][j])
						bfs(i, j);
				}
			}
			
			if(check == 0)
				break;
			else
				day++;
		}
		
		System.out.println(day);		
	}

}