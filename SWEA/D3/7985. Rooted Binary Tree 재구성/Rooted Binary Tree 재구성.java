import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
         	int K = sc.nextInt();
            int N = (int)Math.pow(2, K) - 1;
            int[] arr = new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = sc.nextInt();
            
            System.out.print("#" + test_case + " ");
           	while(K > 0)
            {
            	for(int i = (int)Math.pow(2, K - 1) - 1; i < N; i += (int)Math.pow(2, K))
                {
                	System.out.print(arr[i] + " ");
                }
                K--;
                System.out.println();
            }
		}
	}
}