import java.util.Scanner;

class Solution
{
	static int count;
	static int[] kyuyoung;
	static int[] inyoung;
	
	public static void permutations(int[] output, boolean[] visited, int depth)
	{
		if(depth == 9)
		{
			int kyu = 0;
			int in = 0;
			
			for(int i = 0; i < 9; i++)
			{
				if(kyuyoung[i] > output[i])
					kyu += kyuyoung[i] + output[i];
				else
					in += kyuyoung[i] + output[i];
			}

			if(kyu > in)
				count++;
			return;
		}
		
		for(int i = 0; i < inyoung.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				output[depth] = inyoung[i];
				permutations(output, visited, depth + 1);    
				visited[i] = false;
			}
		}
	}
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            kyuyoung = new int[9];
            inyoung = new int[9];
            boolean[] nums = new boolean[19];
            
            for(int i = 0; i < 9; i++)
            {
            	int n = sc.nextInt();
                kyuyoung[i] = n;
                nums[n] = true;
            }
            	
            int index = 0;
            for(int i = 1; i <= 18; i++)
            {
            	if(!nums[i])
                {
                   inyoung[index] = i;
                    index++;
                }
            }
		
    		int[] output = new int[9];
    		boolean[] visited = new boolean[inyoung.length];
    		count = 0;
    		permutations(output, visited, 0);
    		System.out.printf("#%d %d %d\n", test_case, count, 362880 - count);
		}
	}
}