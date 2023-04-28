import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		char[] nums = (sc.next()).toCharArray();
		int answer = 0;
		for(int i = 0; i < nums.length; i++)
		{
			answer += nums[i] - '0';
		}
		System.out.println(answer);
	}
}