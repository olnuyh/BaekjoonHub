import java.util.Scanner;

public class Solution {    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int D = sc.nextInt();
			
			int answer = 0;
			int count = 0;
			
			for(int i = 0; i < N; i++)
			{
				int broken = sc.nextInt();
				
				if(broken == 1)
					count = 0;
				else
				{
					count++;
					if(count == D)
					{
						answer++;
						count = 0;
					}
				}
			}
			
			System.out.printf("#%d %d\n", test_case, answer);
		}
    }
}
