import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n + 1];
		for(int i = 1; i <= n; i++)
			nums[i] = i;
		int count = 1;
		int start = 1;
		int end = 1;
		int sum = 1;
		while(end < n)
		{
			if(sum == n) {
				count += 1;
				sum -= nums[start];
				start += 1;
			}
			else if(sum < n) {
				end += 1;
				sum += nums[end];
			}
			else if(sum > n) {
				sum -= nums[start];
				start += 1;
			}
		}
		System.out.println(count);
	}
}