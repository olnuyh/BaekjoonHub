import java.util.Scanner;
import java.math.BigInteger;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            BigInteger A = new BigInteger(sc.next());
            BigInteger B = new BigInteger(sc.next());
            
            System.out.print("#" + test_case + " ");
            System.out.println(A.divide(B).multiply(A.divide(B)));
		}
	}
}