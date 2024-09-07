import java.util.*;

class Solution {
    public Map<String, Integer> map;
    
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        map = new HashMap();
        
        for(int i = 0; i < 10; i++) {
            map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
        }
        
        if(check(want, number)){
            answer++;
        }
        
        int start = 0;
        int end = 10;
        
        while(end < discount.length) {
            map.put(discount[end], map.getOrDefault(discount[end], 0) + 1);
            map.put(discount[start], map.get(discount[start]) - 1);
            
            if(map.get(discount[start]) <= 0) {
                map.remove(discount[start]);
            }
            
            if(check(want, number)) {
                answer++;
            }
            
            start++;
            end++;
        }
        
        return answer;
    }
    
    public boolean check(String[] want, int[] number) {
        for(int i = 0; i < want.length; i++) {
            if(!map.containsKey(want[i]) || map.get(want[i]) < number[i]) {
                return false;
            }
        }
        
        return true;
    }
}