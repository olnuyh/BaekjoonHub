import java.util.*;

class Solution {
    public Map<String, List<Integer>> map;
    
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        map = new HashMap();
        
        for (String str : info) {
            String[] applicant = str.split(" ");
            
            makeCase(0, "", applicant);
        }
        
        for (String key : map.keySet()) {
            Collections.sort(map.get(key));    
        }
        
        for (int i = 0; i < query.length; i++) {
            String[] q = query[i].replace(" and ", "").split(" ");
            
            if (map.containsKey(q[0])) {
                int cnt = find(map.get(q[0]), Integer.parseInt(q[1]));
            
                answer[i] = cnt;   
            }
        }
        
        return answer;
    }
    
    public void makeCase (int depth, String cur, String[] applicant) {
        if (depth == 4) {
            if (!map.containsKey(cur)) {
                map.put(cur, new ArrayList());
            }
            
            map.get(cur).add(Integer.parseInt(applicant[depth]));
            
            return;
        }
        
        makeCase(depth + 1, cur + "-", applicant);
        makeCase(depth + 1, cur + applicant[depth], applicant);
    }
    
    public int find (List<Integer> list, int num) {
        int start = 0;
        int end = list.size() - 1;
        
        while (start < end) {
            int mid = (start + end) / 2;
            
            int target = list.get(mid);
            
            if (target < num) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        
        if (list.get(start) >= num) {
            return list.size() - start;
        } else {
            return 0;
        }
    }
}