import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int N, M;
	public static int[] dr = {-1, 1, 0, 0};
	public static int[] dc = {0, 0, -1, 1};
	public static List<int[]> virus;
	public static Queue<int[]> q;
	public static int minTime;
	public static int[][] lab;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		lab = new int[N][N];
		virus = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int val = Integer.parseInt(st.nextToken());
				if(val == 2)
					virus.add(new int[] {i, j});
				lab[i][j] = -val;
			}
		}	
		
		minTime = Integer.MAX_VALUE;
		activate(0, 0, new int[M]);
		
		if(minTime == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(minTime);
	}

	public static void activate(int cnt, int start, int[] selected) {
		if(cnt == M) {
			q = new ArrayDeque<>();
			
			int[][] arr = new int[N][N];
			
			for(int i = 0; i < N; i++)
				arr[i] = lab[i].clone();
			
			for(int i = 0; i < M; i++) {
				int[] pos = virus.get(selected[i]);
				q.offer(pos);
				arr[pos[0]][pos[1]] = 1;
			}
		
			minTime = Math.min(minTime, spread(arr));

			return;
		}
		
		for(int i = start; i < virus.size(); i++) {
			selected[cnt] = i;
			activate(cnt + 1, i + 1, selected);
		}
	}
	
	public static int spread(int[][] arr) {
		int cnt = 0;
		int time = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(arr[i][j] == 0)
					cnt++;
			}
		}
		
		if(cnt == 0)
			return 0;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int t = arr[cur[0]][cur[1]];
			
			for(int i = 0; i < 4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				
				if(arr[nr][nc] == 0) {
					arr[nr][nc] = t + 1;
					q.offer(new int[] {nr, nc});
					cnt--;
					time = Math.max(time, t + 1);
				}else if(arr[nr][nc] == -2) {
					arr[nr][nc] = t + 1;
					q.offer(new int[] {nr, nc});
					time = Math.max(time, t + 1);
				}
			}
			
			if(cnt == 0)
				break;
		}

		if(cnt == 0)
			return time - 1;
		else
			return Integer.MAX_VALUE;
	}
}