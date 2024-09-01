import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        Set<String> set = new HashSet();
        set.add(words[0]);
                
        for(int i = 1; i < words.length; i++) {
            if (words[i].length() == 1 || words[i].charAt(0) != words[i - 1].charAt(words[i - 1].length() - 1) || set.contains(words[i])) {
                answer[0] = (i + 1) % n;
                
                if (answer[0] == 0) {
                    answer[0] += n;
                }
                answer[1] = i / n + 1;

                break;
            } else {
                set.add(words[i]);
            }
        }
        
        return answer;
    }
}