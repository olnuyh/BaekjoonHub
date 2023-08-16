import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int n, cnt;
	public static boolean[] col, leftD, rightD;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		
		cnt = 0;
		
		col = new boolean[n];
		leftD = new boolean[2 * n];
		rightD = new boolean[2 * n];
		
		setQueen(0);
		
		System.out.println(cnt);
	}

	public static void setQueen(int row) {		
		if(row == n) {
			cnt++;
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(col[i] || leftD[row + i] || rightD[i - row + n])
				continue;
			
			col[i] = true;
			leftD[row + i] = true;
			rightD[i - row + n] = true;
			setQueen(row + 1);
			col[i] = false;
			leftD[row + i] = false;
			rightD[i - row + n] = false;
		}
	}
}