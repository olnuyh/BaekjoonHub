import java.util.*;

class Solution {
    public static int[] oneAnswer = {1, 2, 3, 4, 5};
    public static int[] twoAnswer = {2, 1, 2, 3, 2, 4, 2, 5};
    public static int[] threeAnswer = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    
    public int[] solution(int[] answers) {
        int[] count = new int[3];
        
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == oneAnswer[i % 5]) {
                count[0]++;
            }
            
            if (answers[i] == twoAnswer[i % 8]) {
                count[1]++;
            }
            
            if (answers[i] == threeAnswer[i % 10]) {
                count[2]++;
            }
        }
        
        int max = Math.max(count[0], Math.max(count[1], count[2]));
        
        ArrayList<Integer> list = new ArrayList();
        
        for (int i = 0; i < 3; i++) {
            if (count[i] == max) {
                list.add(i + 1);
            }
        }
        
        int[] answer = new int[list.size()];
        
        for (int i = 0, j = 0; i < 3; i++) {
            if (max == count[i]) {
                answer[j++] = i + 1;
            }
        }
        
        return answer;
    }
}