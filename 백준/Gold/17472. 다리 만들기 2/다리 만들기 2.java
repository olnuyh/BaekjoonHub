import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Bridge implements Comparable<Bridge>{
	int island1, island2, length;
	
	public Bridge(int island1, int island2, int length) {
		this.island1 = island1;
		this.island2 = island2;
		this.length = length;
	}

	@Override
	public int compareTo(Bridge o) {
		return this.length - o.length;
	}
}

public class Main {
	public static int[] dr = {-1, 1, 0, 0};
	public static int[] dc = {0, 0, -1, 1};
	public static int[][] map;
	public static int N, M;
	public static PriorityQueue<Bridge> pq;
	public static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		// 각 섬 표시
		int num = 2;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 1) 
					checkIsland(i, j, num++);
			}
		}
		
		num -= 2; // 총 섬 개수
		
		// 섬에서 섬 사이 다리 연결해보기
		pq = new PriorityQueue<>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] != 0)
					buildBridge(i, j, map[i][j]);
			}
		}
		
		// 최소 신장 트리 - 다리 길이를 최소로 모든 섬을 연결
		int sum = 0;
		int cnt = 0;
		parent = new int[num + 2];
		
		for(int i = 2; i < parent.length; i++)
			parent[i] = i;
		
		while(!pq.isEmpty()) {
			if(cnt == num - 1)
				break;
			
			Bridge bridge = pq.poll();
			if(union(bridge.island1, bridge.island2)) {
				sum += bridge.length;
				cnt++;
			}
		}
		
		if(cnt == num - 1)
			System.out.println(sum);
		else
			System.out.println(-1);
	}

	public static void checkIsland(int sr, int sc, int num) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {sr, sc});
		map[sr][sc] = num;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				
				if(map[nr][nc] == 1) {
					map[nr][nc] = num;
					q.offer(new int[] {nr, nc});
				}
			}
		}
	}
	
	public static void buildBridge(int sr, int sc, int num) {
		for(int i = 0; i < 4; i++) {
			for(int j = 1; ; j++) {
				int nr = sr + dr[i] * j;
				int nc = sc + dc[i] * j;
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == num)
					break;
				
				if(map[nr][nc] == 0)
					continue;
				
				if(map[nr][nc] != num) {
					if(j >= 3)
						pq.add(new Bridge(num, map[nr][nc], j - 1));
					break;
				}
			}
		}
	}
	
	public static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		if(pa == pb) return false;
		
		parent[pa] = pb;
		return true;
	}
	
	public static int find(int a) {
		if(a == parent[a])
			return a;
		return parent[a] = find(parent[a]);
	}
}