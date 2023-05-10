import java.util.Scanner;
import java.util.Stack;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
            int N = sc.nextInt();
            String str = sc.next();
            Stack<Character> s = new Stack<>();
            
            for(int i = 0; i < str.length(); i++)
            {
            	if(s.isEmpty())
            	{
            		s.push(str.charAt(i));
            		continue;
            	}
            	
            	if(s.peek() == str.charAt(i))
                    s.pop();
                else
                    s.push(str.charAt(i));
            }
            
            char[] c = new char[s.size()];
            for(int i = c.length - 1; i >= 0; i--)
                c[i] = s.pop();
            
            System.out.println("#" + test_case + " " + String.valueOf(c));
		}
	}
}