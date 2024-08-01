import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int i = 0; i < commands.length; i++) {
            int[] cmd = commands[i];
            int[] splitArr = new int[cmd[1] - cmd[0] + 1];
            
            for (int j = 0; j < splitArr.length; j++) {
                splitArr[j] = array[j + cmd[0] - 1];
            }
            
            Arrays.sort(splitArr);
            
            answer[i] = splitArr[cmd[2] - 1];
        } 
        
        return answer;
    }
}