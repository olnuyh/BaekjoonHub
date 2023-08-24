import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] sushi = new int[n + k - 1];
		for(int i = 0; i < n; i++)
			sushi[i] = Integer.parseInt(br.readLine());
		
		for(int i = n; i < n + k - 1; i++)
			sushi[i] = sushi[i - n];
		
		int[] eat = new int[d + 1];
		eat[c] = 1;
		
		int cnt = 1;
		
		for(int i = 0; i < k; i++) {
			eat[sushi[i]]++;
			
			if(eat[sushi[i]] == 1)
				cnt++;
		}
		
		int maxCnt = cnt;
		
		for(int i = k; i < n + k - 1; i++) {
			eat[sushi[i - k]]--;
			
			if(eat[sushi[i - k]] == 0)
				cnt--;
			
			eat[sushi[i]]++;
			
			if(eat[sushi[i]] == 1)
				cnt++;
			
			maxCnt = Math.max(maxCnt, cnt);
		}
		
		System.out.println(maxCnt);
	}

}