import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        int[] nums = new int[1000001];
        for(int i = 1; i <= 1000000; i++)
            nums[i] = i;

        for(int i = 2; i <= Math.sqrt(1000000); i++)
        {
            for(int j = i + i; j <= 1000000; j += i)
            {
                if(nums[j] == 0)
                    continue;
                nums[j] = 0;
            }
        }

        for(int i = 2; i <= 1000000; i++)
        {
            if(nums[i] != 0)
                System.out.print(nums[i] + " ");
        }
	}
}