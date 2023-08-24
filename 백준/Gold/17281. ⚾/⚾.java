import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int n;
	public static boolean[] visited;
	public static int[][] game;
	public static int maxScore;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		game = new int[n][9];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++)
				game[i][j] = Integer.parseInt(st.nextToken());
		}
		
		visited = new boolean[9];
		maxScore = 0;
		makeOrder(0, new int[9]);
		System.out.println(maxScore);
	}
	
	public static void makeOrder(int cnt, int[] order) {
		if(cnt == 4) {
			if(order[cnt - 1] != 0)
				return;
		}
		
		if(cnt == 9) {
			maxScore = Math.max(maxScore, checkScore(order));
			return;
		}
		
		for(int i = 0; i < 9; i++) {
			if(!visited[i]) {
				visited[i] = true;
				order[cnt] = i;
				makeOrder(cnt + 1, order);
				visited[i] = false;
			}
		}
	}

	public static int checkScore(int[] order) {
		int hitter = 0;
		int score = 0;
		
		for(int i = 0; i < n; i++) {
			int outCnt = 0;
			int base1 = 0, base2 = 0, base3 = 0;
			
			while(outCnt < 3){
				hitter %= 9;
				
				switch(game[i][order[hitter++]]) {
					case 0:
						outCnt++;
						break;
					
					case 1:
						score += base3;
						base3 = base2;
						base2 = base1;
						base1 = 1;
						break;
						
					case 2:
						score += base2 + base3;
						base3 = base1;
						base2 = 1;
						base1 = 0;
						break;
						
					case 3:
						score += base1 + base2 + base3;
						base1 = base2 = 0;
						base3 = 1;
						break;
						
					case 4:
						score += base1 + base2 + base3 + 1;
						base1 = base2 = base3 = 0;
						break;
				}
			}
		}
		
		return score;
	}
}