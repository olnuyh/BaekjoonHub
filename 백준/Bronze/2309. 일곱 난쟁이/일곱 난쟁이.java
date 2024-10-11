import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int[] people;
	public static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		people = new int[9];
		
		for (int i = 0; i < 9; i++) {
			int height = Integer.parseInt(br.readLine());
			
			people[i] = height;
		}
		
		combination(0, 7, 0, new int[7], 0);
		
		System.out.println(sb);
	}
	
	public static boolean combination (int depth, int k, int s, int[] selected, int sum) {
		if (depth == k) {
			if (sum == 100) {
				Arrays.sort(selected);
				
				for (int i = 0; i < selected.length; i++) {
					sb.append(selected[i]).append("\n");
				}
				
				return true;
			}
			
			return false;
		}
		
		for (int i = s; i < 9; i++) {
			selected[depth] = people[i];
			if (combination(depth + 1, k, i + 1, selected, sum + people[i])) {
				return true;
			}
		}
		
		return false;
	}
}