import java.util.Scanner;
import java.util.HashSet;
import java.util.LinkedHashMap;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            StringBuilder sb = new StringBuilder();
            sb.append("#" + test_case + " ");
            
            HashSet<String> hs = new HashSet<>();
            LinkedHashMap<String, Integer> hm = new LinkedHashMap<>();
            hm.put("S", 0);
            hm.put("D", 0);
            hm.put("H", 0);
            hm.put("C", 0);
            
            String str = sc.next();
            
            boolean check = false;
            for(int i = 0; i < str.length(); i += 3)
            {
            	String card = str.substring(i, i + 3);
                if(hs.contains(card))
                {
                    sb.append("ERROR");
                	check = true;
                    break;
                }
                hs.add(card);
                String c = card.substring(0, 1);
                hm.put(c, hm.get(c) + 1);               
            }
            
            if(!check)
            {
               	for(String s : hm.keySet())
                	sb.append(13 - hm.get(s) + " ");
            }
            System.out.println(sb.toString());
		}
	}
}