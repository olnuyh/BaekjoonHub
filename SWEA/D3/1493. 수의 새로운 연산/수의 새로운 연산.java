import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			int[] posA = getPos(a);
			int[] posB = getPos(b);
			
			System.out.printf("#%d %d\n", test_case, getNum(new int[] {posA[0] + posB[0], posA[1] + posB[1]}));
		}
	}
	
	public static int[] getPos(int num)
	{
		int count = 1;
		for(int i = 1; ; i++)
		{
			for(int r = 1, c = i; r <= i; r++, c--)
			{
				if(count == num)
					return new int[] {r, c};
				count++;
			}
		}
	}
	
	public static int getNum(int[] sum)
	{
		int count = 1;
		for(int i = 1; ; i++)
		{
			for(int r = 1, c = i; r <= i; r++, c--)
			{
				if(r == sum[0] && c == sum[1])
					return count;
				count++;
			}
		}
	}
}