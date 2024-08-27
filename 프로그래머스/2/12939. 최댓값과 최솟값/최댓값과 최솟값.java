import java.util.*;

class Solution {
    public String solution(String s) {
        String[] temp = s.split(" ");
        
        int[] nums = new int[temp.length];
        
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(temp[i]);
        }
        
        Arrays.sort(nums);
        
        return nums[0] + " " + nums[nums.length - 1];
    }
}