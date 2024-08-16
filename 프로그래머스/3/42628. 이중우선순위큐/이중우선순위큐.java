import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> maxPq = new PriorityQueue<>((a, b) -> (b - a));
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        List<Integer> list = new ArrayList();
        
        for (int i = 0; i < operations.length; i++) {
            String[] str = operations[i].split(" ");
            
            if (str[0].equals("I")) {
                list.add(Integer.parseInt(str[1]));
                continue;
            }
            
            if (list.size() == 0) {
                continue;
            }
            
            if (str[1].equals("1")) {
                for (int num : list) {
                    maxPq.offer(num);
                }
                
                maxPq.poll();
                
                list.clear();
                
                while (!maxPq.isEmpty()) {
                    list.add(maxPq.poll());
                }
            } else {
                for (int num : list) {
                    minPq.offer(num);
                }
                
                minPq.poll();
                
                list.clear();
                
                 while (!minPq.isEmpty()) {
                    list.add(minPq.poll());
                }
            }
        }
        
        for (int num : list) {
            maxPq.offer(num);
            minPq.offer(num);
        }

        if (maxPq.size() != 0) {
            answer[0] = maxPq.poll();
        }
        
        if (minPq.size() != 0) {
            answer[1] = minPq.poll();
        }
        
        return answer;
    }
}