import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] num = new int[9];
		int sum = 0;
		for(int i = 0; i < 9; i++) {
			num[i] = Integer.parseInt(br.readLine());
			sum += num[i];
		}
		
		for(int i = 0; i < 8; i++) {
			for(int j = i + 1; j < 9; j++) {
				if(sum - num[i] - num[j] == 100) {
					for(int k = 0; k < 9; k++) {
						if(k != i && k != j)
							sb.append(num[k]).append("\n");
					}
				}
			}
		}
			
		System.out.println(sb);
	}

}