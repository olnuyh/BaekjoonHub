import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] score = new int[N][3];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++)
				score[i][j] = Integer.parseInt(st.nextToken());
		}
		
		// 최댓값 구하기
		int[][] scoreResult = new int[2][3];
		for(int i = 0; i < 3; i++)
			scoreResult[1][i] = score[0][i];
		
		for(int i = 0; i < N - 1; i++) {
			for(int j = 0; j < 3; j++) {
				scoreResult[0][j] = scoreResult[1][j];
				scoreResult[1][j] = 0;
			}
			
			scoreResult[1][0] = Math.max(scoreResult[0][0], scoreResult[0][1]) + score[i + 1][0];
			scoreResult[1][1] = Math.max(scoreResult[0][0], Math.max(scoreResult[0][1], scoreResult[0][2])) + score[i + 1][1];
			scoreResult[1][2] = Math.max(scoreResult[0][1], scoreResult[0][2]) + score[i + 1][2];
		}
		
		int max = Math.max(scoreResult[1][0], Math.max(scoreResult[1][1], scoreResult[1][2]));
		
		// 최솟값 구하기
		for(int i = 0; i < 3; i++)
			scoreResult[1][i] = score[0][i];
		
		for(int i = 0; i < N - 1; i++) {
			for(int j = 0; j < 3; j++) {
				scoreResult[0][j] = scoreResult[1][j];
				scoreResult[1][j] = Integer.MAX_VALUE;
			}
			
			scoreResult[1][0] = Math.min(scoreResult[0][0], scoreResult[0][1]) + score[i + 1][0];
			scoreResult[1][1] = Math.min(scoreResult[0][0], Math.min(scoreResult[0][1], scoreResult[0][2])) + score[i + 1][1];
			scoreResult[1][2] = Math.min(scoreResult[0][1], scoreResult[0][2]) + score[i + 1][2];
		}
		
		int min = Math.min(scoreResult[1][0], Math.min(scoreResult[1][1], scoreResult[1][2]));
		
		System.out.println(max + " " + min);
	}
	
}