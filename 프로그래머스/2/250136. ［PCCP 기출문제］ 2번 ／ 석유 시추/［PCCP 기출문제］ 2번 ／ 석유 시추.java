import java.util.*;

class Solution {
    public int[][] deltas = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int n, m;
    
    public boolean[][] visited;
    
    public int[] oil;
    
    public int solution(int[][] land) {
        n = land.length;
        m = land[0].length;
        
        visited = new boolean[n][m];
        oil = new int[m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j, land);
                }
            }
        }
        
        int maxOil = 0;
        
        for (int size : oil) {
            maxOil = Math.max(maxOil, size);
        }
        
        return maxOil;
    }
    
    public void bfs(int r, int c, int[][] land) {
        Queue<int[]> q = new ArrayDeque();
        q.offer(new int[]{r, c});
        
        visited[r][c] = true;
        
        Set<Integer> set = new HashSet();
        set.add(c);
        
        int count = 1;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + deltas[d][0];
                int nc = cur[1] + deltas[d][1];
                
                if(isIn(nr, nc) && land[nr][nc] == 1 && !visited[nr][nc]) {
                    q.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                    count++;
                    set.add(nc);
                }
            }
        }
        
        for (int num : set) {
            oil[num] += count;
        }
    }
    
    public boolean isIn(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }
}