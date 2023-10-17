import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int[][] eggs;
	public static int[] eggState;
	public static int maxCnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		eggs = new int[N][2];
		eggState = new int[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken()); // 내구도
			eggs[i][0] = S;
			eggState[i] = S;
			eggs[i][1] = Integer.parseInt(st.nextToken()); // 무게
		}
		
		maxCnt = 0;
		
		crack(0, 0);
		
		System.out.println(maxCnt);
	}

	public static void crack(int cur, int cnt) {
		if(cur == N) { // 가장 최근에 든 계란이 가장 오른쪽에 위치한 계란인 경우
			maxCnt = Math.max(maxCnt, cnt);
			return;
		}
		
		if(eggState[cur] <= 0) { // 손에 든 계란이 깨져 있는 경우
			crack(cur + 1, cnt);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(i == cur)
				continue;
			
			boolean check = false;

			int newCrack = 0;
			
			if(eggState[i] > 0) {
				eggState[cur] -= eggs[i][1];
				eggState[i] -= eggs[cur][1];
				
				if(eggState[cur] <= 0)
					newCrack++;
				
				if(eggState[i] <= 0)
					newCrack++;
				
				check = true;
			}
			
			crack(cur + 1, cnt + newCrack);
			
			if(check) {
				eggState[cur] += eggs[i][1];
				eggState[i] += eggs[cur][1];
			}
		}
	}
}