import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue();
        
        for (int num : B) {
            pq.offer(num);
        }
        
        Arrays.sort(A);
        int idx = 0;
        
        while (!pq.isEmpty() && idx < A.length) {
            if (pq.peek() > A[idx]) {
                answer++;
                idx++;
            }
            
            pq.poll();
        }
        
        return answer;
    }
}