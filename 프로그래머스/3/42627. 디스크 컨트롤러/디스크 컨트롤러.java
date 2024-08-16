import java.util.*;

class Solution {
    public static class Offer {
        int start, time;
        
        public Offer (int start, int time) {
            this.start = start;
            this.time = time;
        }
    }
    
    public int solution(int[][] jobs) {
        int answer = 0;
        
        Offer[] offers = new Offer[jobs.length];
        
        for (int i = 0; i < jobs.length; i++) {
            offers[i] = new Offer(jobs[i][0], jobs[i][1]);
        }
        
        Arrays.sort(offers, (o1, o2) -> o1.start - o2.start);
        
        int idx = 0;
        int curTime = 0;
        int count = 0;
        
        PriorityQueue<Offer> pq = new PriorityQueue<>((o1, o2) -> o1.time - o2.time);
        
        while (count < jobs.length) {
            while (idx < jobs.length && offers[idx].start <= curTime) {
                pq.offer(offers[idx++]);
            }
            
            if (pq.isEmpty()) {
                curTime = offers[idx].start;
            } else {
                Offer offer = pq.poll();
                curTime += offer.time;
                answer += curTime - offer.start;
                count++;
            }
            
        }
        
        return (int) Math.floor((double)answer / jobs.length);
    }
}