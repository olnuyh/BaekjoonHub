import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			long D = sc.nextInt();
            long L = sc.nextInt();
            long N = sc.nextInt();
            
            long total = D * N + D * (N - 1) * N / 2 * L / 100;
            System.out.printf("#%d %d\n", test_case, total);
		}
	}
}