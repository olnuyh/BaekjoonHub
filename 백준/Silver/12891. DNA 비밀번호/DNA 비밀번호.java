import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		int p = sc.nextInt();
		
		char[] dna = (sc.next()).toCharArray();
		int min_a = sc.nextInt();
		int min_c = sc.nextInt();
		int min_g = sc.nextInt();
		int min_t = sc.nextInt();
		
		int now_a = 0;
		int now_c = 0;
		int now_g = 0;
		int now_t = 0;
		
		for(int i = 0; i < p; i++) {
			if(dna[i] == 'A')
				now_a++;
			else if(dna[i] == 'C')
				now_c++;
			else if(dna[i] == 'G')
				now_g++;
			else
				now_t++;		
		}
		
		int count = 0;
		
		if(now_a >= min_a && now_c >= min_c && now_g >= min_g && now_t >= min_t)
			count++;
		
		int start = 0;
		int end = p - 1;
		
		while(end < s - 1) {
			if(dna[start] == 'A')
				now_a--;
			else if(dna[start] == 'C')
				now_c--;
			else if(dna[start] == 'G')
				now_g--;
			else
				now_t--;
			
			start++;
			end++;
			
			if(dna[end] == 'A')
				now_a++;
			else if(dna[end] == 'C')
				now_c++;
			else if(dna[end] == 'G')
				now_g++;
			else
				now_t++;
			
			if(now_a >= min_a && now_c >= min_c && now_g >= min_g && now_t >= min_t) {
				count++;
			}
		}
		System.out.println(count);
	}
}