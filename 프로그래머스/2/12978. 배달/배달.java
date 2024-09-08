import java.util.*;

class Solution {
    class City implements Comparable<City> {
        int target, distance;
        
        public City(int target, int distance) {
            this.target = target;
            this.distance = distance;
        }
        
        public int compareTo(City c) {
            return this.distance - c.distance;
        }
    }
    
    public List<City>[] town;
    public int[] D;
    public boolean[] visited;
    
    public int solution(int N, int[][] road, int K) {   
        town = new ArrayList[N + 1];
        
        for(int i = 1; i <= N; i++) {
            town[i] = new ArrayList();
        }
        
        for(int[] move : road) {
            int a = move[0];
            int b = move[1];
            int dist = move[2];
            
            town[a].add(new City(b, dist));
            town[b].add(new City(a, dist));
        }
        
        D = new int[N + 1];
        for(int i = 2; i <= N; i++) {
            D[i] = Integer.MAX_VALUE;
        }
        
        visited = new boolean[N + 1];
        delivery();
        
        int answer = 0;
        
        for(int i = 1; i <= N; i++) {
            if(D[i] <= K) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public void delivery() {
        PriorityQueue<City> pq = new PriorityQueue();
        pq.offer(new City(1, 0));
        
        while(!pq.isEmpty()) {
            City cur = pq.poll();
            int curTarget = cur.target;
            
            if(!visited[curTarget]) {
                visited[curTarget] = true;
                
                for(City next : town[curTarget]) {
                    if(D[next.target] > D[curTarget] + next.distance) {
                        D[next.target] = D[curTarget] + next.distance;
                        pq.offer(new City(next.target, D[next.target]));
                    }
                }
            }
        }
    }
}