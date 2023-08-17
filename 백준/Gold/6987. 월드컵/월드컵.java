import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[][] battle;
	public static int[][] result;
	public static int isAvailable;
	
	public static void match(int cnt) {
		if(cnt == 15) { // 15경기를 했을 때
			if(isAvailable == 1) // 이미 가능한 경우의 수가 있는 경우
				return;
			
			for(int i = 0; i < 6; i++) {
				for(int j = 0; j < 3; j++) {
					if(result[i][j] != 0) // 게임 수가 맞지 않을 때
						return;
				}
			}
			isAvailable = 1;
			return;
		}
		
		int country1 = battle[cnt][0];
		int country2 = battle[cnt][1];
		
		// country1이 승리(country2가 패배)
		if(result[country1][0] > 0 && result[country2][2] > 0) {
			result[country1][0]--;
			result[country2][2]--;
			match(cnt + 1);
			result[country1][0]++;
			result[country2][2]++;
		}
		
		// country1과 country2가 무승부
		if(result[country1][1] > 0 && result[country2][1] > 0) {
			result[country1][1]--;
			result[country2][1]--;
			match(cnt + 1);
			result[country1][1]++;
			result[country2][1]++;
		}
		
		// country2가 승리(country1이 패배)
		if(result[country1][2] > 0 && result[country2][0] > 0) {
			result[country1][2]--;
			result[country2][0]--;
			match(cnt + 1);
			result[country1][2]++;
			result[country2][0]++;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		battle = new int[15][2];
		
		for(int i = 0, k = 0; i < 6; i++) {
			for(int j = i + 1; j < 6; j++) {
				battle[k][0] = i;
				battle[k][1] = j;
				k++;
			}
		}
		
		for(int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			result = new int[6][3];
			
			boolean isPossible = true; // 한 국가가 게임을 5경기 하는지 확인
			for(int j = 0; j < 6; j++) {
				int game = 0;
				for(int k = 0; k < 3; k++) {
					result[j][k] = Integer.parseInt(st.nextToken());
					game += result[j][k];
				}
				
				if(isPossible && game != 5)
					isPossible = false;
			}
			
			isAvailable = 0;
			if(isPossible) // 5경기가 아니면 바로 불가능 처리
				match(0);
			sb.append(isAvailable + " ");
		}
		
		System.out.println(sb);
	}

}