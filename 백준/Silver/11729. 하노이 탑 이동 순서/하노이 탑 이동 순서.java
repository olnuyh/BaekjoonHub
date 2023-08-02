import java.util.Scanner;

public class Main {
	static int k;
	static StringBuilder sb = new StringBuilder();
	
	static void hanoi(int nthChoice, int start, int end, int temp) {
		if(nthChoice == 0)
			return;
		
		hanoi(nthChoice - 1, start, temp, end);
		sb.append(start).append(" ").append(end).append("\n");
		k++;
		hanoi(nthChoice - 1, temp, end, start);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		k = 0;
		hanoi(n, 1, 3, 2);
		
		System.out.println(k);
		System.out.println(sb);
	}

}