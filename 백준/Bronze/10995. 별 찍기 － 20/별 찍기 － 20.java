import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= n; i++) {
			if(i % 2 == 0)
				sb.append(" ");
			for(int j = 1; j <= n; j++)
				sb.append("* ");
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}