import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		int[] nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			nums[i] = Integer.parseInt(st.nextToken());
		
		int[] D = new int[N];
		int result = 0;
		for(int i = 0; i < N; i++) {
			D[i] = nums[i];
			for(int j = 0; j < i; j++) {
				if(nums[i] > nums[j])
					D[i] = Math.max(D[i], D[j] + nums[i]);
			}
			
			result = Math.max(result, D[i]);
		}
		
		System.out.println(result);	
	}

}