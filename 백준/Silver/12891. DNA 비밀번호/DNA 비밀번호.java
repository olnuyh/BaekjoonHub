import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String temp = "ACGT";
		
		int s = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		
		String str = br.readLine();
	
		st = new StringTokenizer(br.readLine());
		int[] standard = new int[4];
		for(int i = 0; i < 4; i++)
			standard[i] = Integer.parseInt(st.nextToken());
		
		int[] cnt = new int[4];
		
		for(int i = 0; i < p; i++)
			cnt[temp.indexOf(str.charAt(i))]++;
		
		int answer = 0;
		
		if(cnt[0] >= standard[0] && cnt[1] >= standard[1] && cnt[2] >= standard[2] && cnt[3] >= standard[3])
			answer++;
		
		for(int i = p; i < s; i++) {
			cnt[temp.indexOf(str.charAt(i))]++;
			cnt[temp.indexOf(str.charAt(i - p))]--;
			
			if(cnt[0] >= standard[0] && cnt[1] >= standard[1] && cnt[2] >= standard[2] && cnt[3] >= standard[3])
				answer++;
		}
		
		System.out.println(answer);
	}

}