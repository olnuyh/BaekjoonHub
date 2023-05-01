import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
			int index = Arrays.binarySearch(A, find);
			if(index < 0)
				System.out.println(0);
			else
				System.out.println(1);
		}
	}
}