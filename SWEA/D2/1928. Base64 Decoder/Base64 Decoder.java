import java.util.Scanner;
import java.util.Base64;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            String encode = sc.next();
            String decode = new String(Base64.getDecoder().decode(encode));
            System.out.printf("#%d %s\n", test_case, decode);
		}
	}
}