import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] nums = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(nums, (s1, s2) -> {
            int val1 = Integer.parseInt(s1 + s2);
            int val2 = Integer.parseInt(s2 + s1);
            
            return val2 - val1;
        });
        
        for (int i = 0; i < nums.length; i++) {
            answer += nums[i];
        }
        
        answer = answer.replaceAll("^0+", "0");
        
        return answer;
    }
}