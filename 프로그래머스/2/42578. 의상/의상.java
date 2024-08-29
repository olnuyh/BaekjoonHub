import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, List<String>> map = new HashMap();
        
        for (String[] cloth : clothes) {
            String type = cloth[1];
            String name = cloth[0];
            
            if (map.containsKey(type)) {
                map.get(type).add(name);
            } else {
                List<String> list = new ArrayList();
                list.add(name);
                map.put(type, list);
            }
        }
        
        int match = 1;
        
        for (String key : map.keySet()) {
            match *= map.get(key).size() + 1;
        }
        
        return match - 1;
    }
}