import java.util.Scanner;
import java.math.BigDecimal;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			BigDecimal A = new BigDecimal(sc.next());
            BigDecimal B = new BigDecimal(sc.next());

            System.out.println("#" + test_case + " " + A.add(B));
		}
	}
}