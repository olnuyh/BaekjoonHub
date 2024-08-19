import java.util.*;

class Solution {
    public static int[][] deltas = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static int n, m;
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;

        return move(new int[]{0, 0}, maps);
    }
    
    public int move(int[] start, int[][] maps) {
        Queue<int[]> q = new ArrayDeque();
        boolean[][] visited = new boolean[n][m];
        
        q.offer(start);
        visited[start[0]][start[1]] = true;
        
        int cnt = 1;
        
        while (!q.isEmpty()) {
            int size = q.size();
            
            while (--size >= 0) {
                int[] cur = q.poll();
                
                if (cur[0] == n - 1 && cur[1] == m - 1) {
                    return cnt;
                } 
                
                for (int d = 0; d < 4; d++) {
                    int nr = cur[0] + deltas[d][0];
                    int nc = cur[1] + deltas[d][1];
                    
                    if (isIn(nr, nc)) {
                        if (!visited[nr][nc] && maps[nr][nc] == 1) {
                            visited[nr][nc] = true;
                            q.offer(new int[]{nr, nc});
                        }
                    }
                }
            }
            
            cnt++;
        }
        
        return -1;
    }
    
    public boolean isIn(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }
}