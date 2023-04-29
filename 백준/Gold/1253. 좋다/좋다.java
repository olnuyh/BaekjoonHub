import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int[] A = new int[n];
		
		for(int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(stk.nextToken());
		}
		
		Arrays.sort(A);
		
		int count = 0;
		
		for(int i = 0; i < n; i++) {
			int start = 0;
			int end = n - 1;
			
			while(start < end) {
				if(start == i) {
					start++;
					continue;
				}
				else if(end == i) {
					end--;
					continue;
				}
				
				if(A[start] + A[end] > A[i])
					end--;
				else if(A[start] + A[end] < A[i])
					start++;
				else {
					count++;
					break;
				}
			}
		}
		System.out.println(count);
	}
}