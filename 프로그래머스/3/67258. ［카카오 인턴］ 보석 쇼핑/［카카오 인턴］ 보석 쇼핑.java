import java.util.*;

class Solution {
    public static HashSet<String> hs;
    public static HashMap<String, Integer> hm;
    
    public int[] solution(String[] gems) {
        int[] answer = {0, gems.length - 1};
        
        hs = new HashSet();
        hm = new HashMap();
        
        for (String str : gems) {
            hs.add(str);
        }
        
        int start = 0;
        int end = 0;
        
        hm.put(gems[0], 1);
        
        while (start < gems.length) {
            if (hm.keySet().size() == hs.size()) {
                if (end - start < answer[1] - answer[0]) {
                    answer[0] = start;
                    answer[1] = end;
                }
                
                hm.put(gems[start], hm.getOrDefault(gems[start], 0) - 1);
                
                if (hm.get(gems[start]) == 0) {
                    hm.remove(gems[start]);
                }
                
                start++;
            } else if (end < gems.length - 1) {
                end++;
                hm.put(gems[end], hm.getOrDefault(gems[end], 0) + 1);
            } else {
                break;
            }
        }
        
        return new int[]{answer[0] + 1, answer[1] + 1};
    }
}