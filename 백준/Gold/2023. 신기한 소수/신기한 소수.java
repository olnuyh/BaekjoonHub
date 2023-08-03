import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static StringBuilder sb;
	
	public static boolean isDecimal(int num) {
		for(int i = 2; i <= Math.sqrt(num); i++) {
			if(num % i == 0)
				return false;
		}
		return true;
	}
	
	public static void func(int r, int num) {
		if(r == n) {
			sb.append(num).append("\n");
			return;
		}
		
		for(int i = 1; i < 10; i += 2) {
			if(isDecimal(num * 10 + i))
				func(r + 1, num * 10 + i);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());
		
		int[] nums = {2, 3, 5, 7};
		
		for(int num : nums)
			func(1, num);
		
		System.out.println(sb);
	}

}