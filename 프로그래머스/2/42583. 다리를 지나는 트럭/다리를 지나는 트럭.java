import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new ArrayDeque();
        Queue<Integer> trucks = new ArrayDeque();
        
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }
        
        for (int i = 0; i < truck_weights.length; i++) {
            trucks.offer(truck_weights[i]);
        }
        
        int time = 0;
        int curWeight = 0;
        
        while (!bridge.isEmpty()) {
            curWeight -= bridge.poll();
            
            if (!trucks.isEmpty()) {
                if (curWeight + trucks.peek() <= weight) {
                    bridge.offer(trucks.peek());
                    curWeight += trucks.poll();
                } else {
                    bridge.offer(0);
                }   
            }
            
            time++;
        }
        
        return time;
    }
}