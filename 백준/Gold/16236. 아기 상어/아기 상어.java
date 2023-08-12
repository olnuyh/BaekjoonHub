import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Fish{
	int r, c, distance;
	
	Fish(int r, int c, int distance){
		this.r = r;
		this.c = c;
		this.distance = distance;
	}
}

public class Main {
	public static int[] dr = {-1, 1, 0, 0};
	public static int[] dc = {0, 0, -1, 1};
	
	public static int n;
	public static int[][] map;
	public static int[] shark;
	public static int sharkSize;
	public static PriorityQueue<Fish> canEat;
	
	public static void bfs(int r, int c) {
		Queue<int []> q = new ArrayDeque<>();
		q.offer(new int[] {r, c});
		
		int[][] visited = new int[n][n];
		visited[r][c] = 1;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			for(int i = 0; i < 4; i++) {
				int nr = now[0] + dr[i];
				int nc = now[1] + dc[i];
				
				if(nr < 0 || nr >= n || nc < 0 || nc >= n)
					continue;
				
				if(visited[nr][nc] == 0 && map[nr][nc] <= sharkSize) {
					visited[nr][nc] = visited[now[0]][now[1]] + 1;
					q.offer(new int[] {nr, nc});
					
					if(map[nr][nc] != 0 && map[nr][nc] < sharkSize) {
						canEat.offer(new Fish(nr, nc, visited[nr][nc] - 1));
					}
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		
		shark = new int[2];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					shark[0] = i;
					shark[1] = j;
				}
			}
		}
		
		sharkSize = 2;
		int cnt = 0;
		int time = 0;
		
		while(true) {
			canEat = new PriorityQueue<>((o1, o2) ->  {
				if(o1.distance == o2.distance) {
					if(o1.r == o2.r)
						return o1.c - o2.c;
					return o1.r - o2.r;
				}
				return o1.distance - o2.distance;
			});
			
			bfs(shark[0], shark[1]);
			
			if(canEat.size() == 0)
				break;
			else {
				Fish dest = canEat.poll();

				map[shark[0]][shark[1]] = 0;			
				map[dest.r][dest.c] = 9;
				shark[0] = dest.r;
				shark[1] = dest.c;
				cnt++;
				
				if(cnt == sharkSize) {
					cnt = 0;
					sharkSize++;
				}
				
				time += dest.distance;
			}
			
		}
		
		System.out.println(time);
	}

}