import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Link implements Comparable<Link>{
	int r, c, amount;
	
	public Link(int r, int c, int amount) {
		this.r = r;
		this.c = c;
		this.amount = amount;
	}

	@Override
	public int compareTo(Link o) {
		return this.amount - o.amount;
	}
}

public class Main {
	public static int N;
	public static int[] dr = {-1, 1, 0, 0};
	public static int[] dc = {0, 0, -1, 1};
	public static boolean[][] visited;
	public static int[][] rupee;
	public static int[][] result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int tc = 1; ; tc++){
			N = Integer.parseInt(br.readLine());
			
			if(N == 0)
				break;
			
			rupee = new int[N][N];
			result = new int[N][N];
			visited = new boolean[N][N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					rupee[i][j] = Integer.parseInt(st.nextToken());
					result[i][j] = Integer.MAX_VALUE;
				}
			}
			
			move();
			
			sb.append("Problem ").append(tc).append(": ").append(result[N - 1][N - 1]).append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static void move() {
		PriorityQueue<Link> pq = new PriorityQueue<>();
		pq.offer(new Link(0, 0, rupee[0][0]));
		visited[0][0] = true;
		
		while(!pq.isEmpty()) {
			Link cur = pq.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) continue;
				
				if(result[nr][nc] > rupee[nr][nc] + cur.amount) {
					visited[nr][nc] = true;
					result[nr][nc] = rupee[nr][nc] + cur.amount;
					pq.offer(new Link(nr, nc, result[nr][nc]));
				}
			}
		}
	}
}