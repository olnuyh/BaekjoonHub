import java.util.*;

class Solution {
    public int n, m;
    public int[][] deltas = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public boolean[][] visited;
    
    public int[] solution(String[] maps) {
        List<Integer> list = new ArrayList();
        
        n = maps.length;
        m = maps[0].length();
        
        visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i].charAt(j) != 'X' && !visited[i][j]) {
                    visited[i][j] = true;
                    list.add((maps[i].charAt(j) - '0') + bfs(maps, new int[]{i, j}));
                }
            }
        }
        
        if (list.size() == 0) {
            return new int[]{-1};
        } 
        
        int[] arr = new int[list.size()];
            
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        
        Arrays.sort(arr);

        return arr;

    }
    
    public int bfs(String[] maps, int[] start) {
        Queue<int[]> q = new ArrayDeque();
        q.offer(start);
        
        int days = 0;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + deltas[d][0];
                int nc = cur[1] + deltas[d][1];
                
                if (isIn(nr, nc) && maps[nr].charAt(nc) != 'X' && !visited[nr][nc]) {
                    q.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                    days += maps[nr].charAt(nc) - '0';
                }
            }
        }
        
        return days;
    }
    
    public boolean isIn(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }
}