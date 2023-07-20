import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class FineDust{
	int r, c, amount;
	
	public FineDust(int r, int c, int amount){
		this.r = r;
		this.c = c;
		this.amount = amount;
	}
}

public class Main {
	public static int r, c;
	public static int airR;
	public static int[][] house;
	
	public static boolean isIn(int nr, int nc, boolean up) {
		if(up) {
			return nr >= 0 && nr < airR && nc >= 0 && nc < c;
		}
		else {
			return nr >= airR && nr < r && nc >= 0 && nc < c;
		}
	}
	
	// 공기 청정기
	public static void airCleaner(int nr, int[][] deltas, boolean up) { 
		int nowR = nr;
		int nowC = 0;
		int d = 0;
		
		while(true) { 
			int nextR = nowR + deltas[d][0];
			int nextC = nowC + deltas[d][1];
			
			if(isIn(nextR, nextC, up)){
				int temp = house[nextR][nextC];
				if(temp == -1) {
					house[nowR][nowC] = 0;
					break;
				}
				house[nowR][nowC] = house[nextR][nextC];
			}
			else {
				d++;
				house[nowR][nowC] = house[nowR + deltas[d][0]][nowC + deltas[d][1]];
			}
			
			nowR += deltas[d][0];
			nowC += deltas[d][1];
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(stk.nextToken());
		c = Integer.parseInt(stk.nextToken());
		int t = Integer.parseInt(stk.nextToken());
		
		house = new int[r][c];
		
		for(int i = 0; i < r; i++){
			stk = new StringTokenizer(br.readLine());
			for(int j = 0; j < c; j++) {
				int temp = Integer.parseInt(stk.nextToken());
				if(temp == -1)
					airR = i;
				house[i][j] = temp;
			}
		}
		
		int[][] deltas1 = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 미세먼지 확산, 위쪽 공기 청정기
		int[][] deltas2 = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; // 아래쪽 공기 청정기
		
		for(int i = 0; i < t; i++) { // t초 후 상태(t번 반복)
			// 1. 미세먼지 확산
			ArrayList<FineDust> list = new ArrayList<>();
			
			for(int j = 0; j < r; j++) {
				for(int k = 0; k < c; k++) {
					if(house[j][k] > 0)
						list.add(new FineDust(j, k, house[j][k]));
				}
			}
			
			for(int j = 0; j < list.size(); j++) {
				int nowR = list.get(j).r;
				int nowC = list.get(j).c;
				int dustAmount = list.get(j).amount;
				
				int count = 0;
				for(int k = 0; k < 4; k++) {
					int nextR = nowR + deltas1[k][0];
					int nextC = nowC + deltas1[k][1];
					
					if(nextR >= 0 && nextR < r && nextC >= 0 && nextC < c && house[nextR][nextC] >= 0) {
						count++;
						house[nextR][nextC] += dustAmount / 5;
					}
				}
				house[nowR][nowC] -= dustAmount / 5 * count;
			}
			
			// 2. 공기청정기 작동
			airCleaner(airR - 2, deltas1, true);// 위쪽
			airCleaner(airR + 1, deltas2, false); // 아래쪽
		}
		
		int total = 0;
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(house[i][j] > 0)
					total += house[i][j];
			}
		}
		
		System.out.println(total);
	}

}