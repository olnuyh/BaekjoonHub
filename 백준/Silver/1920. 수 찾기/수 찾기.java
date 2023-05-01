import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] A = new int[n];
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			A[i] = Integer.parseInt(stk.nextToken());
		
		Arrays.sort(A);
		
		int m = Integer.parseInt(br.readLine());
		stk = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++)
		{
			int find = Integer.parseInt(stk.nextToken());
			boolean isPresent = false;
			int start = 0;
			int end = n - 1;
			
			while(start <= end)
			{
				int median = (start + end) / 2;
				if(A[median] == find)
				{
					isPresent = true;
					break;
				}
				else if(A[median] > find)
					end = median - 1;
				else
					start = median + 1;
			}
			
			if(isPresent)
				System.out.println(1);
			else
				System.out.println(0);
		}
	}
	}