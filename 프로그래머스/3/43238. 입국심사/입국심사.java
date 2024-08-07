class Solution {
    public long solution(int n, int[] times) {  
        return findMinTime(n, times);
    }
    
    public long findMinTime(int n, int[] times) {
        long start = 1;
        long end = 1000000000000000000L;
        
        while (start < end) {
            long mid = (start + end) / 2;
            
            long people = 0;
            for (int i = 0; i < times.length; i++) {
                people += mid / times[i];
            }
            
            if (n > people) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        
        return start;
    }
}