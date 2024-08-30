import java.util.*;

class Solution {
    public List<Integer>[] map;
    public int[] visited;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        
        map = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            map[i] = new ArrayList();
        }
        
        for (int[] road : roads) {
            int a = road[0];
            int b = road[1];
            
            map[a].add(b);
            map[b].add(a);
        }
        
        visited = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            visited[i] = -1;
        }
        
        move(destination, n);
        
        for (int i = 0; i < sources.length; i++) {
            answer[i] = visited[sources[i]];
        }
        
        return answer;
    }
    
    public void move (int start, int n) {
        Queue<Integer> q = new ArrayDeque();
        q.offer(start);
        
        visited[start] = 0;
        
        int count = 1;
        
        while (!q.isEmpty()) {
            int size = q.size();
            
            while (--size >= 0) {
                int cur = q.poll();
                
                for (int next : map[cur]) {
                    if (visited[next] == -1) {
                        q.offer(next);
                        visited[next] = count;
                    }
                }
            }
            
            count++;
        }
    }
}