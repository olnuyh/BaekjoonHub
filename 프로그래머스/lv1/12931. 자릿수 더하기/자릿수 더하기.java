import java.util.*;

public class Solution {
    public int solution(int n) {
        int max_size = 9;
        int answer = 0;
        int count = 0;
        int j = 1;
        
        while(count != max_size)
        {
            answer += (n / j) % 10;
            j *= 10;
            count += 1;
        }

        return answer;
    }
}