import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] grow = new int[2 * M - 1];
		for(int i = 0; i < grow.length; i++)
			grow[i] = 1;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0, t = 0; j < 3; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				for(int k = 0; k < tmp; k++)
					grow[t++] += j;
			}
		}
		
		int[][] result = new int[M][M];
		for(int r = 0; r < M; r++) {
			for(int c = 1; c < M; c++)
				result[r][c] = grow[M + c - 1];
		}
		
		for(int r = 0; r < M; r++)
			result[r][0] = grow[M - r - 1];
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < M; j++)
				sb.append(result[i][j]).append(" ");
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}