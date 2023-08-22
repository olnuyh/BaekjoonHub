import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int l, c;
	public static StringBuilder sb;
	public static char[] password;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		password = new char[c];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < c; i++) 
			password[i] = st.nextToken().charAt(0);
		
		Arrays.sort(password);
		makePassword(0, 0, new char[l]);
		System.out.println(sb);
	}
	
	public static void makePassword(int cnt, int start, char[] alphabets) {
		if(cnt == l) {
			int vowels = 0;
			for(int i = 0; i < l; i++) {
				if("aeiou".indexOf(alphabets[i]) >= 0)
					vowels++;
			}
			
			if(vowels >= 1 && l - vowels >= 2) {
				for(int i = 0; i < l; i++) 
					sb.append(alphabets[i]);
				sb.append("\n");
			}
			return;
		}
		
		for(int i = start; i < c; i++) {
			alphabets[cnt] = password[i];
			makePassword(cnt + 1, i + 1, alphabets);
		}
	}

}