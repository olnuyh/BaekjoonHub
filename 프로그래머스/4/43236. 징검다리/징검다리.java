import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int[] pos = new int[rocks.length + 1];
        
        for (int i = 0; i < rocks.length; i++) {
            pos[i] = rocks[i];
        }
        
        pos[pos.length - 1] = distance;
        
        Arrays.sort(pos);
        
        int start = 1;
        int end = distance + 1;
        
        while (end - start > 1) {
            int mid = (start + end) / 2;
            
            int remove = 0;
            int rock = 0;
            
            for (int i = 0; i < pos.length; i++) {
                if (pos[i] - rock < mid) {
                    remove++;
                } else {
                    rock = pos[i];
                }
            }
            
            if (remove <= n) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        return start;
    }
}