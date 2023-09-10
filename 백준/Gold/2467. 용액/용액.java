import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] solution = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			solution[i] = Integer.parseInt(st.nextToken());
		
		int result = Integer.MAX_VALUE;
		int[] answer = new int[2];
		
		int start = 0;
		int end = N - 1;
		
		while(start < end) {
			int sum = solution[start] + solution[end];
			if(Math.abs(sum) < result) {
				result = Math.abs(sum);
				answer[0] = solution[start];
				answer[1] = solution[end];
			}
			
			if(sum <= 0)
				start++;
			else
				end--;
		}
		
		System.out.println(answer[0] + " " + answer[1]);
	}

}