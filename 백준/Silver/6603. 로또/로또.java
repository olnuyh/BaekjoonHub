import java.util.*;

class Main{
	public static int k;
	public static int[] arr;
	public static boolean[] visited;
	
	public static void Backtracking(int start, int count, int[] output)
	{
		if(count == 6)
		{
			for(int i = 0; i < 6; i++)
				System.out.print(output[i] + " ");
			System.out.println();
			return;
		}
		
		for(int i = start; i < k; i++)
		{
			if(!visited[i])
			{
				visited[i] = true;
				output[count] = arr[i];
				Backtracking(i + 1, count + 1, output);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true)
		{
			k = sc.nextInt();
			
			if(k == 0)
				break;
			
			arr = new int[k];
			visited = new boolean[k];
			
			for(int i = 0; i < k; i++)
				arr[i] = sc.nextInt();
			
			int[] output = new int[k];
			Backtracking(0, 0, output);
			System.out.println();
		}
	}
}