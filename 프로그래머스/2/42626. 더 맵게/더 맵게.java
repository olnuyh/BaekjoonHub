import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int count = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue();
        
        for (int num : scoville) {
            pq.offer(num);
        }
        
        while (pq.size() >= 2 && pq.peek() < K) {
            int first = pq.poll();
            int second = pq.poll();
            
            pq.offer(first + second * 2);
            count++;
        }
                
        if (pq.peek() >= K) {
            return count;
        } else {
            return -1;
        }

    }
}