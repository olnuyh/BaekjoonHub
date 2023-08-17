import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int n, minDiff;
	public static int[][] stats;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		stats = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++)
				stats[i][j] = Integer.parseInt(st.nextToken());
		}
		
		minDiff = Integer.MAX_VALUE;
		comb(0, 0, new int[n / 2]);
		
		System.out.println(minDiff);
	}
	
	public static void comb(int cnt, int start, int[] choosed) {
		if(cnt == n / 2) {
			int startTeam = checkScore(choosed);
			int[] link = new int[n / 2];
			for(int i = 0, k = 0; i < n; i++) {
				boolean isIn = false;
				for(int j = 0; j < n / 2; j++) {
					if(i == choosed[j]) {
						isIn = true;
						break;
					}
				}
				
				if(!isIn)
					link[k++] = i;
			}
			
			int linkTeam = checkScore(link);
			
			minDiff = Math.min(minDiff, Math.abs(startTeam - linkTeam));
			return;
		}
		
		for(int i = start; i < n; i++) {
			choosed[cnt] = i;
			comb(cnt + 1, i + 1, choosed);
		}
	}
	
	public static int checkScore(int[] arr) {
		int score = 0;
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				if(i == j) continue;
				score += stats[arr[i]][arr[j]];
			}
		}
		
		return score;
	}

}