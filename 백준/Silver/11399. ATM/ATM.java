import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int[] A = new int[n];
		for(int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(stk.nextToken());
		}
		
		for(int i = 1; i < n; i++) {
			int index = -1;
			int value = A[i];
			
			for(int j = i - 1; j >= 0; j--) {
				if(A[i] < A[j])
					index = j;
				else
					break;
			}
			
			if(index >= 0) {
				for(int j = i; j > index; j--) {
					A[j] = A[j - 1];
				}
				
				A[index] = value;
			}
		}
		
		int[] S = new int[n];
		S[0] = A[0];
		
		for(int i = 1; i < n; i++)
			S[i] = S[i - 1] + A[i];
		
		int answer = 0;
		for(int i = 0; i < n; i++)
			answer += S[i];
		
		System.out.println(answer);
	}
}