import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) { 
        Map<String, Integer> map1 = new HashMap();

        for (String s : participant) {
            map1.put(s, map1.getOrDefault(s, 0) + 1);
        }
        
        for (String s : completion) {
            if(map1.get(s) == 1) {
                map1.remove(s);
            } else {
                map1.put(s, map1.get(s) - 1);
            }
        }
        
        for (String s : map1.keySet()) {
            return s;
        }
        
        return null;
    }
}