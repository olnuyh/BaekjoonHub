import java.util.*;

class Solution {
    public static Map<String, List<Integer>> map;
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        map = new HashMap();
        
        for (int i = 0; i < info.length; i++) {
            String[] conditions = info[i].split(" ");
            makeCases(0, "", conditions);
        }
        
        for (List<Integer> list : map.values()) {
            Collections.sort(list);
        }
        
        for (int i = 0; i < query.length; i++) {
            String[] conditions = query[i].split(" ");

            int score = Integer.parseInt(conditions[conditions.length - 1]);
            
            String condition = "";
            for (int j = 0; j < conditions.length - 1; j += 2) {
                condition += conditions[j];
            }

            if (map.containsKey(condition)) {
                List<Integer> scores = map.get(condition);
                
                int val = check(scores, score);

                answer[i] = scores.size() - val;
            } else {
                answer[i] = 0;
            }
        }
        
        return answer;
    }
    
    public static void makeCases(int idx, String cur, String[] conditions) {
        if (idx == 4) {
            map.putIfAbsent(cur, new ArrayList());
            map.get(cur).add(Integer.parseInt(conditions[4]));

            return;
        }
        
        makeCases(idx + 1, cur + "-", conditions);
        makeCases(idx + 1, cur + conditions[idx], conditions);
    }
    
    public static int check(List<Integer> scores, int score) {
        int start = 0;
        int end = scores.size() - 1;
        
        while (start < end) {
            int mid = (start + end) / 2;
            
            if (scores.get(mid) >= score) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        
        if (scores.get(start) >= score) {
            return start;
        } else {
            return scores.size();
        }
    }
}