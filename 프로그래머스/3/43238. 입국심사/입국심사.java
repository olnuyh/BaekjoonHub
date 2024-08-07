class Solution {
    public long solution(int n, int[] times) { 
        long start = 1;
        long end = 1000000000000000000L;
        
        long answer = Long.MAX_VALUE;
        
        while (start <= end) {
            long mid = (start + end) / 2;
            
            long people = 0;
            for (int i = 0; i < times.length; i++) {
                people += mid / times[i];
            }
            
            if (n > people) {
                start = mid + 1;
            } else {
                end = mid - 1;
                answer = Math.min(answer, mid);
            }
        }
        
        return answer;
    }
}