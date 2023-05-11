import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = sc.nextInt();
            int[][] farm = new int[N][N];
            
            int answer = 0;
            
            for(int i = 0; i < N; i++)
            {
                String s = sc.next();
                for(int j = 0; j < N; j++)
                {
                	farm[i][j] = s.charAt(j) - '0';
                    if(i == N / 2)
                        answer += farm[i][j];
                }
            }
            
            for(int i = 0; i < N / 2; i++)
            {
            	for(int j = N / 2 - i; j <= N / 2 + i; j++)
                {
                	answer += farm[i][j];
               	    answer += farm[N - 1 - i][j];
                }
            }
            
            System.out.printf("#%d %d\n", test_case, answer);
		}
	}
}