import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();
            int D = sc.nextInt();
            
            int win1 = A * D;
            int win2 = B * C;
            
            if(win1 == win2)
                System.out.printf("#%d DRAW\n", test_case);
            else if(win1 > win2)
                System.out.printf("#%d ALICE\n", test_case);
            else
                System.out.printf("#%d BOB\n", test_case);
		}
	}
}