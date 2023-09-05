import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] nums = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			nums[i] = Integer.parseInt(st.nextToken());
		
		int[] D = new int[N];
		int answer = 1;
		
		for(int i = 0; i < N; i++) {
			D[i] = 1;
			for(int j = 0; j < i; j++) {
				if(nums[j] < nums[i])
					D[i] = Math.max(D[i], D[j] + 1);
			}
			
			answer = Math.max(answer, D[i]);
		}
		
		System.out.println(answer);
	}

}