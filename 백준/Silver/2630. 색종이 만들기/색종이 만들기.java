import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[][] paper;
	public static int white, blue;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		paper = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++)
				paper[i][j] = Integer.parseInt(st.nextToken());
		}
		
		white = 0;
		blue = 0;
		
		count(0, 0, n);
		System.out.println(white);
		System.out.println(blue);
	}

	public static void count(int sr, int sc, int len) {
		int sum = 0;
		for(int r = sr; r < sr + len; r++) {
			for(int c = sc; c < sc + len; c++) 
				sum += paper[r][c];
		}
		
		if(sum == 0)
			white++;
		else if(sum == len * len)
			blue++;
		else {
			int half = len / 2;
			
			count(sr, sc, half);
			count(sr, sc + half, half);
			count(sr + half, sc, half);
			count(sr + half, sc + half, half);
		}
	}
}