import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for (int i = 0; i < s.length(); i++) {
            Stack<Character> stack = new Stack();
            boolean isRight = true;
            
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt((i + j) % s.length());
                
                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                    continue;
                }
                
                if (stack.isEmpty() || c == ')' && stack.peek() != '(' || c == '}' && stack.peek() != '{' || c == ']' && stack.peek() != '[') {
                    isRight = false;
                    break;
                } else {
                    stack.pop();
                }
            }
            
            if (stack.isEmpty() && isRight) {
                answer++;
            }
        }
        
        return answer;
    }
}