import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int[][] video;
	public static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		video = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			for(int j = 0; j < n; j++)
				video[i][j] = str.charAt(j) - '0';
		}
		
		compression(0, 0, n);
		System.out.println(sb);
	}
	
	public static void compression(int sr, int sc, int size) {
		int sum = 0;
		for(int r = sr; r < sr + size; r++) {
			for(int c = sc; c < sc + size; c++)
				sum += video[r][c];
		}
		
		if(sum == 0)
			sb.append("0");
		else if(sum == size * size)
			sb.append("1");
		else {
			int half = size / 2;
			sb.append("(");
			compression(sr, sc, half);
			compression(sr, sc + half, half);
			compression(sr + half, sc, half);
			compression(sr + half, sc + half, half);
			sb.append(")");
		}
	}

}