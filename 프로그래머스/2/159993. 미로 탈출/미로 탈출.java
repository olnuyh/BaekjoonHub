import java.util.*;

class Solution {
    public int n, m;
    public int[][] deltas = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    public int solution(String[] maps) {
        int answer = 0;
        
        n = maps.length;
        m = maps[0].length();
        
        int[] start = new int[2];
        int[] end = new int[2];
        int[] lever = new int[2];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int c = maps[i].charAt(j);
                if (c == 'S') {
                    start[0] = i;
                    start[1] = j;
                } else if (c == 'E') {
                    end[0] = i;
                    end[1] = j;
                } else if (c == 'L') {
                    lever[0] = i;
                    lever[1] = j;
                }
            }
        }
        
        int result1 = bfs(maps, start, lever);
        
        if (result1 == -1) {
            return -1;
        }
        
        int result2 = bfs(maps, lever, end);
        
        if (result2 == -1) {
            return -1;
        }
        
        return result1 + result2;
    }
    
    public int bfs (String[] maps, int[] start, int[] end) {
        Queue<int[]> q = new ArrayDeque();
        boolean[][] visited = new boolean[n][m];
        
        q.offer(start);
        visited[start[0]][start[1]] = true;
        
        int count = 0;
        
        while (!q.isEmpty()) {
            int size = q.size();
            
            while (--size >= 0) {
                int[] cur = q.poll();
                
                if (cur[0] == end[0] && cur[1] == end[1]) {
                    return count;
                }
                
                for (int d = 0; d < 4; d++) {
                    int nr = cur[0] + deltas[d][0];
                    int nc = cur[1] + deltas[d][1];
                    
                    if (isIn(nr, nc) && maps[nr].charAt(nc) != 'X' && !visited[nr][nc]) {
                        q.offer(new int[]{nr, nc});
                        visited[nr][nc] = true;
                    }
                }
            }
            
            count++;
        }
        
        return -1;
    }
    
    public boolean isIn(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }
}