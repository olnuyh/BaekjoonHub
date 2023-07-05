import java.util.*;

class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int[] fibo0 = new int[41];
		int[] fibo1 = new int[41];
		
		fibo0[0] = 1;
		fibo0[1] = 0;
		
		for(int i = 2; i <= 40; i++)
			fibo0[i] = fibo0[i - 1] + fibo0[i - 2];
		
		fibo1[0] = 0;
		fibo1[1] = 1;
		
		for(int i = 2; i<= 40; i++)
			fibo1[i] = fibo1[i - 1] + fibo1[i - 2];
		
		for(int i = 0; i < T; i++)
		{
			int n = sc.nextInt();
			System.out.print(fibo0[n] + " " + fibo1[n]);
			System.out.println();
		}
	}
}