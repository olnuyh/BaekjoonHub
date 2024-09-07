import java.util.*;

class Solution {
    public int solution(int[] elements) {     
        Set<Integer> set = new HashSet();
        
        int[] arr = new int[elements.length];
        
        for (int i = 1; i <= elements.length; i++) {           
            for (int j = 0; j < elements.length; j++) {
                arr[j] += elements[(i + j - 1) % elements.length];
                set.add(arr[j]);
            }
        }
        
        return set.size();
    }
}