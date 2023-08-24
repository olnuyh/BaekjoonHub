import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class FireBall implements Comparable<FireBall>{
	int r, c, m, s, d;
	
	public FireBall(int r, int c, int m, int s, int d){
		this.r = r;
		this.c = c;
		this.m = m;
		this.s = s;
		this.d = d;
	}

	@Override
	public int compareTo(FireBall o) {
		if(this.r == o.r)
			return this.c - o.c;
		return this.r - o.r;
	}
}

public class Main {
	public static int N;
	
	public static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	public static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	public static int[][] dir = {{0, 2, 4, 6}, {1, 3, 5, 7}};
	
	public static ArrayList<FireBall> beforeMove;
	public static PriorityQueue<FireBall> afterMove;
	
	public static int[][] count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		beforeMove = new ArrayList<>();
		afterMove = new PriorityQueue<>();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			beforeMove.add(new FireBall(r, c, m, s, d));
		}
		
		for(int i = 0; i < K; i++) {
			count = new int[N][N];
			moveFireBalls();
			
			combineFireBalls();
		}
		
		int sumM = 0;
		for(int i = 0; i < beforeMove.size(); i++)
			sumM += beforeMove.get(i).m;
		
		System.out.println(sumM);
	}
	
	public static void moveFireBalls() {
		for(FireBall f : beforeMove) {
			int nr = (N + f.r + dr[f.d] * (f.s % N)) % N;
			int nc = (N + f.c + dc[f.d] * (f.s % N)) % N;
			
			count[nr][nc]++;
			afterMove.offer(new FireBall(nr, nc, f.m, f.s, f.d));
		}
		
		beforeMove.clear();
	}

	public static void combineFireBalls() {
		while(!afterMove.isEmpty()) {
			FireBall f = afterMove.poll();
			int cnt = count[f.r][f.c];
			
			if(cnt == 1) {
				beforeMove.add(f);
				continue;
			}
			
			int m = f.m;
			int s = f.s;
			
			int oddCnt = f.d % 2 == 0? 0 : 1;
			
			for(int i = 0; i < cnt - 1; i++) {
				FireBall f2 = afterMove.poll();
				m += f2.m;
				s += f2.s;
				if(f2.d % 2 != 0)
					oddCnt++;
			}

			if(m / 5 == 0)
				continue;
			
			int flag = 1;
			if(oddCnt == 0 || oddCnt == cnt)
				flag = 0;
			
			for(int i = 0; i < 4; i++)
				beforeMove.add(new FireBall(f.r, f.c, m / 5, s / cnt, dir[flag][i]));
		}
	}
}