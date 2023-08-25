import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Shark{
	int r, c, s, d, z;
	
	public Shark(int s, int d, int z) {
		this.s = s; // 속력
		this.d = d; // 이동 방향
		this.z = z; // 상어 크기
	}
	
	public Shark(int r, int c, int s, int d, int z) {
		this.r = r; // 행
		this.c = c; // 열
		this.s = s; // 속력
		this.d = d; // 이동 방향
		this.z = z; // 상어 크기
	}
}

public class Main {
	public static int R, C;
	
	public static int[] dr = {-1, 1, 0, 0};
	public static int[] dc = {0, 0, 1, -1};
	
	public static Shark[][] fishing;
	public static int sumSharkSize;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken()); // 행 수
		C = Integer.parseInt(st.nextToken()); // 열 수
		int M = Integer.parseInt(st.nextToken()); // 상어 수
		
		fishing = new Shark[R][C];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken()) - 1;
			int z = Integer.parseInt(st.nextToken());
			
			fishing[r][c] = new Shark(s, d, z);
		}
		
		int fisherman = -1; // 낚시왕 열 위치
		sumSharkSize = 0;
		
		while(fisherman < C - 1) { // 낚시왕이 끝까지 이동하면 종료
			// 1. 낚시왕 이동
			fisherman++;
			
			// 2. 낚시왕이 있는 열에 있는 상어중 제일 가까운 상어 잡기
			catchShark(fisherman);
			
			// 3. 상어 이동
			moveShark();
		}
		
		System.out.println(sumSharkSize);
	}

	public static void catchShark(int col) {
		for(int i = 0; i < R; i++) {
			Shark shark = fishing[i][col];
			if(shark != null) {
				sumSharkSize += shark.z; // 잡은 상어 크기 저장
				fishing[i][col] = null; // 잡은 상어 제거
				break;
			}
		}
	}
	
	public static void moveShark() {
		// 모든 상어 담기
		ArrayList<Shark> list = new ArrayList<>();
		
		for(int i = 0; i < R; i++) { 
			for(int j = 0; j < C; j++) {
				if(fishing[i][j] != null) {
					Shark originShark = fishing[i][j];
					list.add(new Shark(i, j, originShark.s, originShark.d, originShark.z));
					fishing[i][j] = null;
				}
			}
		}
		
		for(int i = 0; i < list.size(); i++) {
			Shark shark = list.get(i);
			
			int dir = 1; // 원래 방향인지 반대 방향인지 표시
			int move = shark.s; // 상어가 이동해야 하는 칸 수
			
			// 상어가 이동하다 자기 자리로 돌아오기를 반복하는 것을 방지
			if(shark.d == 0 || shark.d == 1)
				move %= 2 * (R - 1);
			else if(shark.d == 2 || shark.d == 3)
				move %= 2 * (C - 1);
			
			int nr = shark.r;
			int nc = shark.c; // 이동한 위치 표시
			
			while(move > 0) {
				nr += dr[shark.d] * dir;
				nc += dc[shark.d] * dir;
				
				if(nr >= 0 && nr < R && nc >= 0 && nc < C) { // 이동했을 때 낚시장 안에 있으면
					move--; // 영역 안에 있으면 이동
					continue;
				}
				
				nr -= dr[shark.d] * dir;
				nc -= dc[shark.d] * dir;
				dir *= -1; // 영역 벗어나면 위치 되돌리고 방향 반전시키기
			}
			
			if(dir == -1) { // 방향 바뀐 상어 처리
				if(shark.d == 0)
					shark.d = 1;
				else if(shark.d == 1)
					shark.d = 0;
				else if(shark.d == 2)
					shark.d = 3;
				else
					shark.d = 2;
			}
			
			Shark newShark = new Shark(shark.s, shark.d, shark.z); // 새로운 위치의 상어
			
			if(fishing[nr][nc] == null) // 만약 해당 위치에 상어가 없으면
				fishing[nr][nc] = newShark; // 새로운 상어 위치시키기
			else {
				Shark shark2 = fishing[nr][nc]; // 해당 위치에 상어가 있으면
				if(shark2.z < newShark.z) // 더 큰 상어가 들어가게 하기
					fishing[nr][nc] = newShark;
			}
		}
	}
}