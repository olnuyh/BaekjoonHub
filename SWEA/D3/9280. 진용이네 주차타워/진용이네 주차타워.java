import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.PriorityQueue;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			int[] rate = new int[n];
			int[] weight = new int[m];
			int[] parking = new int[m];
			
			for(int i = 0; i < n; i++)
				rate[i] = sc.nextInt();
			
			for(int i = 0; i < m; i++)
				weight[i] = sc.nextInt();
			
			int money = 0;
			Queue<Integer> waitQueue = new LinkedList<>();
			PriorityQueue<Integer> parkingQueue = new PriorityQueue<>();
			
			for(int i = 0; i < n; i++)
				parkingQueue.add(i);
			
			for(int i = 0; i < 2 * m; i++)
			{
				int c = sc.nextInt();
				if(c > 0)
				{	
					if(parkingQueue.isEmpty())
						waitQueue.add(c - 1);
					else
						parking[c - 1] = parkingQueue.poll();
				}
				else
				{
					money += rate[parking[-c - 1]] * weight[-c - 1];
					parkingQueue.add(parking[-c - 1]);
					
					if(!waitQueue.isEmpty())
						parking[waitQueue.poll()] = parkingQueue.poll();
				}
			}
			System.out.printf("#%d %d\n", test_case, money);
		}
	}
}