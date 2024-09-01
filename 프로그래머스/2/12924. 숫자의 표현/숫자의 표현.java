class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int start = 0;
        int end = 1;
        
        int sum = end;
        
        while (start <= end) {
            if (sum == n) {
                answer++;
                end++;
                sum += end;
            } else if (sum > n) {
                sum -= start;
                start++;
            } else {
                end++;
                sum += end;
            }
        }
        
        return answer;
    }
}