import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        while(sc.hasNext())
        {
        	int T = sc.nextInt();
            Queue<Integer> q = new LinkedList<>();

            for(int i = 0; i < 8; i++)
                q.add(sc.nextInt());

            int[] num = {1, 2, 3, 4, 5};
            int index = 0;

            while(true)
            {
                int a = q.poll();
                if(a - num[index] <= 0)
                {
                    q.add(0);
                    break;
                }
                else
                {
                    q.add(a - num[index]);
                    index = (index + 1) % 5;
                }
        	}
            
            System.out.printf("#%d ", T);
        	for(int i = 0; i < 8; i++)
            	System.out.print(q.poll() + " ");
        	System.out.println();
        }
	}
}