import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		
		boolean[] switches = new boolean[n + 1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if(tmp == 0)
				switches[i] = false;
			else
				switches[i] = true;
		}
		
		int m = Integer.parseInt(br.readLine());
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			if(gender == 1) {
				for(int j = num; j <= n; j += num)
					switches[j] = !switches[j];
			}else {
				switches[num] = !switches[num];
				
				for(int j = 1; ; j++) {
					if(num - j <= 0 || num + j > n || switches[num - j] != switches[num + j])
						break;
					switches[num - j] = !switches[num - j];
					switches[num + j] = !switches[num + j];
				}
			}
		}
		
		for(int i = 1; i <= n; i++) {
			if(switches[i])
				sb.append("1 ");
			else
				sb.append("0 ");
			
			if(i % 20 == 0)
				sb.append("\n");
		}
		
		System.out.println(sb);
		
	}

}