import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int[] arr = new int[3];
            for(int i = 0; i < 3; i++)
                arr[i] = sc.nextInt() - 11;
            
            int answer = arr[0] * 1440 + arr[1] * 60 + arr[2];
            
            System.out.print("#" + test_case + " ");
            if(answer < 0)
                System.out.println(-1);
            else
                System.out.println(answer);
		}
	}
}