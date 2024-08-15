import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList();
        
        Queue<Integer> queue = new ArrayDeque();
        
        for (int i = 0; i < progresses.length; i++) {
            int time = (int)Math.ceil((double)(100 - progresses[i]) / speeds[i]);
            queue.add(time);
        }
        
        while (!queue.isEmpty()) {
            int cnt = 1;
            int time = queue.poll();
            
            while (!queue.isEmpty() && queue.peek() <= time) {
                queue.poll();
                cnt++;
            }
            
            list.add(cnt);
        }
        
        int[] answer = new int[list.size()];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}