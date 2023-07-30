import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int n = sc.nextInt();
		int num = sc.nextInt();
		int[] pos = new int[2];
		
		int[][] deltas = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
		
		int[][] snail = new int[n][n];
		
		int cnt = n * n;
		int r = -1; 
		int c = 0;
		int d = 0;
		
		while(cnt > 0) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			
			if(nr < 0 || nr >= n || nc < 0 || nc >= n || snail[nr][nc] != 0) {
				d = (d + 1) % 4;
				continue;
			}

			if(cnt == num) {
				pos[0] = nr + 1;
				pos[1] = nc + 1;
			}
			
			snail[nr][nc] = cnt--;

			r = nr;
			c = nc;
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++)
				sb.append(snail[i][j] + " ");
			
			sb.append("\n");
		}
		
		sb.append(pos[0] + " " + pos[1]);
		System.out.println(sb);
	}

}