import java.util.*;

class Solution {
    public static Map<String, Integer> map;
    public static int max;
    
    public String[] solution(String[] orders, int[] course) {
        for (int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }
        
        ArrayList<String> list = new ArrayList();
        
        for (int i = 0; i < course.length; i++) {
            max = 0;
            map = new HashMap();
            
            for (int j = 0; j < orders.length; j++) {
                String str = orders[j];
                
                if (str.length() < course[i]) {
                    continue;
                }
                
                makeCourse(orders, str, new char[course[i]], 0, 0, course[i]);
            }
            
            if (max < 2) {
                continue;
            }
            
            for (String s : map.keySet()) {
                if (map.get(s) == max) {
                    list.add(s);
                }
            }
        }
        
        String[] answer = new String[list.size()];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
    
    public void makeCourse (String[] orders, String original, char[] cur, int idx, int start, int len) {
        if (idx == len) {
            String str = String.valueOf(cur);
            
            map.put(str, map.getOrDefault(str, 0) + 1);
            // System.out.println(map.get(str));
            max = Math.max(max, map.get(str));

            return;
        }
        
        for (int i = start; i < original.length(); i++) {
            cur[idx] = original.charAt(i);
            makeCourse(orders, original, cur, idx + 1, i + 1, len);
        }
    }
}