import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] A = new int[n];
		for(int i = 0; i < n; i++)
			A[i] = sc.nextInt();
		
		for(int i = 0; i < n - 1; i++) {
			for(int j = 0; j < n - i - 1; j++) {
				if(A[j] > A[j + 1]) {
					int tmp = A[j + 1];
					A[j + 1] = A[j];
					A[j] = tmp;
				}
			}
		}
		for(int i = 0; i < n; i++)
			System.out.println(A[i]);
	}
}