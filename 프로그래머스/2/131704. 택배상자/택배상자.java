import java.util.*;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack();
        
        int idx = 1;
        int boxes = 0;
        
        for (int num : order) {
            while(idx < num) {
                stack.push(idx++);
            }
            
            if (num == idx) {
                idx++;
                boxes++;
                continue;
            }
            
            if (!stack.isEmpty() && num == stack.peek()) {
                stack.pop();
                boxes++;
                continue;
            }
            
            break;
        }
        
        return boxes;
    }
}