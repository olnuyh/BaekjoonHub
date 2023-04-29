import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(stk.nextToken());
		stk = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(stk.nextToken());
		
		int[] materials = new int[n];
		
		stk = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
		{
			materials[i] = Integer.parseInt(stk.nextToken()); 
		}
		
		Arrays.sort(materials);
		
		int count = 0;
		int start = 0;
		int end = n - 1;
		
		while(start < end) {
			int sum = materials[start] + materials[end];
			
			if(sum == m) {
				count++;
				start++;
				end--;
			}
			else if(sum > m) {
				end--;
			}
			else if(sum < m) {
				start++;
			}
		}
		System.out.println(count);
	}
}