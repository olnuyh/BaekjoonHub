import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Shark implements Comparable<Shark>{
	int r, c, num, dir;
	
	public Shark(int r, int c, int num) {
		this.r = r;
		this.c = c;
		this.num = num;
	}
	
	public Shark(int r, int c, int num, int dir) {
		this.r = r;
		this.c = c;
		this.num = num;
		this.dir = dir;
	}

	@Override
	public int compareTo(Shark o) {
		return this.num - o.num;
	}
}

class Smell{
	int r, c, num, time;
	
	public Smell(int num, int time) {
		this.num = num;
		this.time = time;
	}
	
	public Smell(int r, int c, int num, int time) {
		this.r = r;
		this.c = c;
		this.num = num;
		this.time = time;
	}
}

public class Main {
	public static PriorityQueue<Shark> sharkPQ;
	public static List<Shark> list;
	public static List<Smell> smellList;
	
	public static int[] dr = {-1, 1, 0, 0}; // 위, 아래, 왼쪽, 오른쪽 
	public static int[] dc = {0, 0, -1, 1};
	
	public static int[][][] priorityArr;
	public static Smell[][] smellArr;
	public static int[][] sharkPos;
	public static int N, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 2차원 배열 한 변의 길이
		int M = Integer.parseInt(st.nextToken()); // 처음 상어 수
		K = Integer.parseInt(st.nextToken()); // 냄새가 사라지는 데 걸리는 시간
		
		sharkPos = new int[N][N]; // 상어 현재 위치 저장
		sharkPQ = new PriorityQueue<>(); // 상어 번호, 위치, 방향 저장
		smellArr = new Smell[N][N]; // 냄새 위치 저장
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				sharkPos[i][j] = Integer.parseInt(st.nextToken());
				if(sharkPos[i][j] != 0)
					smellArr[i][j] = new Smell(sharkPos[i][j], K); // 처음 상어 위치에 냄새 뿌리기
			}
		}
		
		// 처음 상어 방향 저장
		st = new StringTokenizer(br.readLine());
		int[] direction = new int[M + 1];
		for(int i = 1; i <= M; i++) 
			direction[i] = Integer.parseInt(st.nextToken()) - 1;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(sharkPos[i][j] != 0) {
					sharkPQ.offer(new Shark(i, j, sharkPos[i][j], direction[sharkPos[i][j]]));
					sharkPos[i][j] = 0;
				}
			}
		}
		
		priorityArr = new int[M + 1][4][4]; // 각 상어 별 현재 방향에 대한 이동 우선순위 저장
		for(int i = 1; i <= M; i++) {
			for(int j = 0; j < 4; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k = 0; k < 4; k++)
					priorityArr[i][j][k] = Integer.parseInt(st.nextToken()) - 1;
			}
		}
		
		int t = 0;
		while(t <= 1000) {
			if(sharkPQ.size() == 1) // 1번 상어만 남으면
				break;
						
			moveShark(); // 상어 이동
			// 냄새 제한 시간 1씩 줄이기
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(smellArr[i][j] != null) {
						smellArr[i][j].time--;
						if(smellArr[i][j].time == 0) // 시간 제한 끝나면 냄새 사라짐
							smellArr[i][j] = null;
					}
				}
			}
			t++;
		}
		
		if(t == 1001)
			System.out.println("-1");
		else
			System.out.println(t);
	}

	public static void moveShark() {
		list = new ArrayList<Shark>(); // 다음 상어 리스트 임시 저장
		smellList = new ArrayList<Smell>(); // 다음 냄새 리스트 임시 저장
		// 작은 번호 상어부터 이동
		while(!sharkPQ.isEmpty()) {
			Shark now = sharkPQ.poll();
			
			int[] next = {-1, -1, -1}; // 위치, 방향
			// 냄새가 없는 칸이 있는지 확인
			for(int d = 0; d < 4; d++) {
				int nr = now.r + dr[priorityArr[now.num][now.dir][d]];
				int nc = now.c + dc[priorityArr[now.num][now.dir][d]];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				
				if(smellArr[nr][nc] == null) {
					next[0] = nr;
					next[1] = nc;
					next[2] = priorityArr[now.num][now.dir][d];
					break;
				}
			}
			
			// 냄새가 없는 칸이 없으면, 자신의 냄새가 있는 칸 확인
			if(next[0] == -1) {
				for(int d = 0; d < 4; d++) {
					int nr = now.r + dr[priorityArr[now.num][now.dir][d]];
					int nc = now.c + dc[priorityArr[now.num][now.dir][d]];
					
					if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
					
					if(smellArr[nr][nc].num == now.num) {
						next[0] = nr;
						next[1] = nc;
						next[2] = priorityArr[now.num][now.dir][d];
						break;
					}
				}
			}
			
			// 상어 이동
			if(sharkPos[next[0]][next[1]] == 0) { // 이동하려는 곳에 상어가 없는 경우에만 이동 가능
				sharkPos[next[0]][next[1]] = now.num;
				sharkPos[now.r][now.c] = 0;
				smellList.add(new Smell(next[0], next[1], now.num, K + 1));
				//smellArr[next[0]][next[1]] = new Smell(now.num, K + 1);
				list.add(new Shark(next[0], next[1], now.num, next[2]));
			}
		}
		
		for(int i = 0; i < list.size(); i++)
			sharkPQ.offer(list.get(i));
		
		for(int i = 0; i < smellList.size(); i++) {
			Smell smell = smellList.get(i);
			smellArr[smell.r][smell.c] = new Smell(smell.num, smell.time);
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++)
				sharkPos[i][j] = 0;
		}
	}
}