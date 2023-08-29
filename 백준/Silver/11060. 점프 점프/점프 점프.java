import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] maze = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			maze[i] = Integer.parseInt(st.nextToken());
		
		int[] D = new int[n];
		Arrays.fill(D, Integer.MAX_VALUE);
		D[0] = 0;
		
		for(int i = 0; i < n; i++) {
			int num = maze[i];
			
			if(D[i] == Integer.MAX_VALUE)
				continue;
			
			for(int j = 1; j <= num; j++)
				if(i + j < n) {
					D[i + j] = Math.min(D[i + j], D[i] + 1);
				} 
		}

		if(D[n - 1] == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(D[n - 1]);
	} 

}