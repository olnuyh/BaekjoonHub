import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> st = new Stack<>();
        st.add(arr[0]);
        for(int i = 1; i < arr.length; i++)
        {
            if(st.peek() != arr[i])
                st.add(arr[i]);
        }
        
        int[] answer = new int[st.size()];
        
        for(int i = st.size() - 1; i >= 0; i--)
        {
            answer[i] = st.pop();
        }

        return answer;
    }
}