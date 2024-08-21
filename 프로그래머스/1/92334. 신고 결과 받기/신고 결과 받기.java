import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        HashMap<String, Integer> hm = new HashMap();
        
        for (int i = 0; i < id_list.length; i++) {
            hm.put(id_list[i], i);
        }
        
        HashSet<String> hs = new HashSet();
        int[] count = new int[id_list.length];
        
        for (String str : report) {
            if (!hs.contains(str)) {
                hs.add(str);
                String[] splited = str.split(" ");
                count[hm.get(splited[1])]++;
            }
        }
        
        for (String str : hs) {
            String[] splited = str.split(" ");
            if (count[hm.get(splited[1])] >= k) {
                answer[hm.get(splited[0])]++;
            }
        }
        
        return answer;
    }
}