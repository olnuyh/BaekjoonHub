import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		boolean[] input1 = new boolean[n];
		boolean[] input2 = new boolean[n];
		boolean[] output = new boolean[n];
		
		String temp = br.readLine();
		for(int i = 0; i < n; i++) {
			if(temp.charAt(i) == '0') {
				input1[i] = false;
				input2[i] = false;
			}
			else {
				input1[i] = true;
				input2[i] = true;
			}
		}
		
		temp = br.readLine();
		for(int i = 0; i < n; i++) {
			if(temp.charAt(i) == '0')
				output[i] = false;
			else
				output[i] = true;
		}
		
		int cnt1 = 1;
		input1[0] = !input1[0];
		input1[1] = !input1[1];
		
		for(int i = 1; i < n; i++) {
			if(input1[i - 1] != output[i - 1]) {
				for(int j = -1; j < 2; j++) {
					if(i + j >= n)
						continue;
					
					input1[i + j] = !input1[i + j];
				}
				
				cnt1++;
			}
		}
		
		int cnt2 = 0;
		
		for(int i = 1; i < n; i++) {
			if(input2[i - 1] != output[i - 1]) {
				for(int j = -1; j < 2; j++) {
					if(i + j >= n)
						continue;
					
					input2[i + j] = !input2[i + j];
				}
				
				cnt2++;
			}
		}
		
		if(input1[n - 1] != output[n - 1])
			cnt1 = Integer.MAX_VALUE;
		
		if(input2[n - 1] != output[n - 1])
			cnt2 = Integer.MAX_VALUE;
		
		if(cnt1 == Integer.MAX_VALUE && cnt2 == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(Math.min(cnt1, cnt2));
		
	}

}