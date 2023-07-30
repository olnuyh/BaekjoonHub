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
		int r = 0; 
		int c = 0;
		int d = 0;
		
		while(cnt > 0) {
			if(r >= 0 && r < n && c >= 0 && c < n && snail[r][c] == 0) {
				if(cnt == num) {
					pos[0] = r + 1;
					pos[1] = c + 1;
				}
				snail[r][c] = cnt--;
			}
			else {
				r -= deltas[d][0];
				c -= deltas[d][1];
				d = (d + 1) % 4;
			}
			
			r += deltas[d][0];
			c += deltas[d][1];
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++)
				sb.append(snail[i][j] + " ");
			
			if(i == n - 1)
				break;
			sb.append("\n");
		}
		
		System.out.println(sb);
		System.out.println(pos[0] + " " + pos[1]);
	}

}