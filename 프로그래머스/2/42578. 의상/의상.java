import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap();
        
        for (String[] cloth : clothes) {
            String type = cloth[1];
            
            map.put(type, map.getOrDefault(type, 1) + 1);
        }
        
        int match = 1;
        
        for (String key : map.keySet()) {
            match *= map.get(key);
        }
        
        return match - 1;
    }
}