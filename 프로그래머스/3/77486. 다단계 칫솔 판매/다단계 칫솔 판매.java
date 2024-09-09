import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        Map<String, Integer> organization = new HashMap();
        for(int i = 0; i < enroll.length; i++) {
            organization.put(enroll[i], i);
        }
        
        for(int i = 0; i < seller.length; i++) {
            String cur = seller[i];
            int price = amount[i] * 100;
            
            while(!cur.equals("-") && price > 0) {
                int idx = organization.get(cur);
                answer[idx] += price - (price / 10);
                
                cur = referral[idx];
                price /= 10;
            }    
        }
        
        return answer;
    }
}