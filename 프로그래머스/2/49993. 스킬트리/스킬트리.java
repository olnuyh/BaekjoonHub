import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for (String str : skill_trees) {
            List<Integer> list = new ArrayList();
            
            for (char c : skill.toCharArray()) {
                list.add(str.indexOf(c));
            }
            
            if (isPossible (list)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public boolean isPossible (List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) == -1) {
                if (list.get(i + 1) == -1) {
                    continue;
                }
                return false;
            }
            
            if (list.get(i + 1) != -1 && list.get(i) > list.get(i + 1)) {
                return false;
            }
        }
        
        return true;
    }
}