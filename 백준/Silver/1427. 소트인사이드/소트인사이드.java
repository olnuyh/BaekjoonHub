import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int[] A = new int[str.length()];
		
		for(int i  = 0; i < str.length(); i++) {
			A[i] = str.charAt(i) - '0';
		}
		
		for(int i  = 0; i < A.length; i++) {
			int max = i;
			
			for(int j = i; j < A.length; j++) {
				if(A[max] < A[j]) {
					max = j;
				}
			}
			int temp = A[i];
			A[i] = A[max];
			A[max] = temp;
		}
		
		for(int i = 0; i < A.length; i++)
			System.out.print(A[i]);
	}
}