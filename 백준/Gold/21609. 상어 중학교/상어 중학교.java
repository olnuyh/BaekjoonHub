import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

class BlockGroup implements Comparable<BlockGroup>{
	int size, rainbow, stR, stC;
	
	public BlockGroup(int size, int rainbow, int stR, int stC) {
		this.size = size;
		this.rainbow = rainbow;
		this.stR = stR;
		this.stC = stC;
	}

	@Override
	public int compareTo(BlockGroup o) {
		if(this.size == o.size) {
			if(this.rainbow == o.rainbow) {
				if(this.stR == o.stR)
					return o.stC - this.stC;
				return o.stR - this.stR;
			}
			return o.rainbow - this.rainbow;
		}
		return o.size - this.size;
	}
}

public class Main {
	public static int[] dr = {-1, 1, 0, 0};
	public static int[] dc = {0, 0, -1, 1};
	public static boolean[][] visited;
	public static int N, M;
	public static int[][] blocks;
	public static PriorityQueue<BlockGroup> pq;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		blocks = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++)
				// 일반 블록 자연수, 검은색 블록 -1, 무지개 블록 0
				blocks[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int score = 0;
		
		// 오토 플레이
		while(true) {
			visited = new boolean[N][N];
			pq = new PriorityQueue<>();
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					for(int k = 0; k < N; k++) {
						for(int t = 0; t < N; t++)
							if(blocks[k][t] == 0 && visited[k][t])
								visited[k][t] = false;
					}
					
					if(!visited[i][j] && blocks[i][j] >= 0)
						findBlockGroup(i, j);
				}
			}
			
			if(pq.size() == 0) break;
			
			BlockGroup bg = pq.poll();
			
			removeBlockGroup(bg.stR, bg.stC);
			
			score += Math.pow(bg.size, 2);
			
			gravity();
			rotate();
			gravity();
		}
		
		System.out.println(score);
	}

	public static void findBlockGroup(int r, int c) {
		Queue<int []> q = new ArrayDeque<>();
		visited[r][c] = true;
		q.offer(new int[] {r, c});
		
		int size = 1; // 총 블록 개수
		int color = M + 1; // 일반 블록 색상
		int rainbow = 0; // 무지개 블록 개수
		int[] std = {N + 1, N + 1}; // 기준 블록
		
		if(blocks[r][c] == 0)
			rainbow++;
		else {
			color = blocks[r][c];
			
			if(r < std[0]) { // 기준 블록 처리
				std[0] = r;
				std[1] = c;
			}else if(r == std[0] && c < std[1])
				std[1] = c;
		}
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				
				if(!isIn(nr, nc) || visited[nr][nc] || blocks[nr][nc] < 0) continue;
				
				if(blocks[nr][nc] == 0) // 무지개 블록일 경우
					rainbow++;
				else { // 일반 블록인 경우
					if(color == M + 1) // 일반 블록이 아직 하나도 없으면
						color = blocks[nr][nc];
					else {
						if(blocks[nr][nc] != color) continue;
					}
					
					if(nr < std[0]) { // 기준 블록 처리
						std[0] = nr;
						std[1] = nc;
					}else if(nr == std[0] && nc < std[1])
						std[1] = nc;
				}
				
				size++;
				q.offer(new int[] {nr, nc});
				visited[nr][nc] = true;
			}
		}
		
		if(color != M + 1 && size >= 2) // 일반 블록이 한 개라도 있고 총 블록 개수가 두 개 이상일 때
			pq.offer(new BlockGroup(size, rainbow, std[0], std[1]));
	}
	
	public static void removeBlockGroup(int r, int c) {
		Queue<int []> q = new ArrayDeque<>();
		q.offer(new int[] {r, c});
		
		int color = M + 1; // 일반 블록 색상
		if(blocks[r][c] > 0)
			color = blocks[r][c];
		
		blocks[r][c] = -2;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				
				if(!isIn(nr, nc) || blocks[nr][nc] < 0) continue;
				
				if(blocks[nr][nc] > 0) {
					if(color == M + 1) // 일반 블록이 아직 하나도 없으면
						color = blocks[nr][nc];
					else
						if(blocks[nr][nc] != color) continue;
				}

				q.offer(new int[] {nr, nc});
				blocks[nr][nc] = -2;
			}
		}
	}
	
	public static void gravity() {
		Stack<Integer> stack = new Stack<>();
		for(int c = 0; c < N; c++) { // 모든 열에 대해
			for(int r = N - 1; r >= 0 ; r--) {
				if(blocks[r][c] < 0)
					stack.push(blocks[r][c]);
				else {
					int cnt = 0;
					while(!stack.isEmpty() && stack.peek() == -2) {
						stack.pop();
						cnt++;
					}
					stack.push(blocks[r][c]);
					while(cnt-- > 0)
						stack.push(-2);
				}
			}
		
			while(stack.size() < N)
				stack.push(-2);
			
			for(int r = 0; r < N; r++)
				blocks[r][c] = stack.pop();
		}
	}
	
	public static void rotate() {
		int[][] newBlocks = new int[N][N];
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++)
				newBlocks[N - 1 - c][r] = blocks[r][c];
		}
		
		for(int r = 0; r < N; r++)
			blocks[r] = newBlocks[r].clone();
	}
	
	public static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}