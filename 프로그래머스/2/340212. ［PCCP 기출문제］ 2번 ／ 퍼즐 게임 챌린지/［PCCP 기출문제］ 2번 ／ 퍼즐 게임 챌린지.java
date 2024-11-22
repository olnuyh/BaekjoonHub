class Solution {
    
    public int solution(int[] diffs, int[] times, long limit) {
        int start = 1;
        int end = 0;
        
        for (int diff : diffs) {
            end = Math.max(end, diff);
        }
        
        while (start <= end) {
            int mid = (start + end) / 2;
            
            long time = solve(mid, diffs, times, limit);
            
            if (time > limit) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return start;
    }
    
    public long solve (int level, int[] diffs, int[] times, long limit) {
        long time = 0;
        
        for (int i = 0; i < diffs.length; i++) {
            if (diffs[i] <= level) {
                time += times[i];
            } else {
                time += (times[i - 1] + times[i]) * (diffs[i] - level) + times[i];
            }
        }
        
        return time;
    }
}