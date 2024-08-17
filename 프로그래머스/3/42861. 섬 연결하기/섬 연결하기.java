import java.util.*;

class Solution {
    public static class Bridge implements Comparable<Bridge> {
        int start, end, cost;
        
        public Bridge (int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
        
        public int compareTo (Bridge b) {
            return this.cost - b.cost;
        }
    }
    
    public static int[] parents;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        PriorityQueue<Bridge> pq = new PriorityQueue();
        
        for (int i = 0; i < costs.length; i++) {
            pq.offer(new Bridge(costs[i][0], costs[i][1], costs[i][2]));
        }
        
        parents = new int[n];
        
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        
        int count = 0;
        
        while (!pq.isEmpty()) {
            Bridge b = pq.poll();
            
            if (union(b.start, b.end)) {
                answer += b.cost;
                count++;
            }
            
            if (count == n - 1) {
                break;
            }
        }
        
        return answer;
    }
    
    public boolean union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);
        
        if (parentA == parentB) {
            return false;
        }
        
        parents[parentA] = parentB;
        
        return true;
    }
    
    public int find(int a) {
        if (parents[a] == a) {
            return a;
        }
        
        return find(parents[a]);
    }
}