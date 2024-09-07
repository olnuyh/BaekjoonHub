import java.util.*;

class Solution {
    public int solution(int[] elements) {     
        int[] arr = new int[2 * elements.length];
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = elements[i % elements.length];
        }
        
        Set<Integer> set = new HashSet();
        
        for (int i = 1; i <= elements.length; i++) {
            int sum = 0;
            
            for (int j = 0; j < i; j++) {
                sum += arr[j];
            }
            
            set.add(sum);
            
            int start = 0;
            int end = i;
            
            while(end < arr.length) {
                sum += arr[end];
                sum -= arr[start];
                set.add(sum);
                
                end++;
                start++;
            }
        }
        
        return set.size();
    }
}