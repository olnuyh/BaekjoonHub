import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n, k;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		
		if(n <= 20) {
			k = 0;
			hanoi(n, 1, 3, 2);
			System.out.println(k);
			System.out.println(sb);	
		}
		else {
			BigInteger[] dp = new BigInteger[n + 1];
			dp[1] = new BigInteger("1");
			for(int i = 2; i <= n; i++)
				dp[i] = dp[i - 1].multiply(new BigInteger("2")).add(new BigInteger("1"));
			System.out.println(dp[n]);
		}
	}
	
	static void hanoi(int cnt, int start, int end, int temp) {
		if(cnt == 0)
			return;
		
		hanoi(cnt - 1, start, temp, end);
		sb.append(start + " " + end + "\n");
		k++;
		hanoi(cnt - 1, temp, end, start);
	}

}