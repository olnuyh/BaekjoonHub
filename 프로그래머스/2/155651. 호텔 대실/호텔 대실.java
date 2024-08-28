import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[0] - o2[0]));
        
        for (String[] time : book_time) {
            int start = Integer.parseInt(time[0].replace(":", ""));
            int end = Integer.parseInt(time[1].replace(":", ""));
            
            end += 10;
            
            if (end % 100 >= 60) {
                end += 40;
            }
            
            pq.offer(new int[]{start, end});
        }
        
        List<Integer> times = new ArrayList();
        
        while (!pq.isEmpty()) {
            int[] schedule = pq.poll();
            
            boolean isPossible = false;
            
            for (int i = 0; i < times.size(); i++) {
                if (times.get(i) <= schedule[0]) {
                    isPossible = true;
                    times.set(i, schedule[1]);
                    break;
                }
            }
            
            if (!isPossible) {
                answer++;
                times.add(schedule[1]);
            }
            
            Collections.sort(times);
        }
        
        return answer;
    }
}