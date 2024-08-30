import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int work : works) {
            pq.offer(work);
        } 
        
        for (int i = 0; i < n; i++) {
            int cur = pq.poll();
            if (cur == 0) {
                break;
            }
            pq.offer(cur - 1);
        }
        
        while (!pq.isEmpty()) {
            int num = pq.poll();
            answer += num * num;
        }
        
        return answer;
    }
}