import java.util.Scanner;

class Solution
{
    public static int[] arr;
    public static int count;
    public static int N;
    
    public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            N = sc.nextInt();
            arr = new int[N];
            count = 0;
            nQueen(0);
            System.out.printf("#%d %d\n", test_case, count);
		}
	}
    
    public static void nQueen(int depth)
    {
    	if(depth == N)
        {
        	count++;
            return;
        }
        
        for(int i = 0; i < N; i++)
        {
        	arr[depth] = i;
            if(possible(depth))
                nQueen(depth + 1);
        }
    }
	
    public static boolean possible(int col)
    {
    	for(int i = 0; i < col; i++)
        {
        	if(arr[i] == arr[col])
                return false;
            else if(Math.abs(col - i) == Math.abs(arr[col] - arr[i]))
                return false;
        }
        return true;
    }
}