import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int type = 0;
        
        Map<Integer, Integer> map = new HashMap();
        
        for (int num : tangerine) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        
        for (int num : map.keySet()) {
            pq.offer(map.get(num));
        }
        
        int count = k;
        
        while (count > 0) {
            count -= pq.poll();
            type++;
        }
        
        return type;
    }
}