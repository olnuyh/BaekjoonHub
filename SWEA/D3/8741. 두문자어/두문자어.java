import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
            StringBuilder sb = new StringBuilder();
            sb.append("#" + test_case + " ");
            String[] words = br.readLine().split(" ");
            for(int i = 0; i < words.length; i++)
            	sb.append(words[i].substring(0, 1).toUpperCase());

            System.out.println(sb.toString());
		}
	}
}