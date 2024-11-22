import java.util.*;

class Solution {
    public int[] amount;
    public int R, C;
    public boolean[][] visited;
    public int[][] deltas = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    public int solution(int[][] land) {
        R = land.length;
        C = land[0].length;
        
        amount = new int[C];
        
        visited = new boolean[R][C];
        
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    find(new int[]{i, j}, land);
                }
            }
        }
        
        int answer = 0;
        
        for (int i = 0; i < C; i++) {
            answer = Math.max(answer, amount[i]);    
        }
        
        return answer;
    }
    
    public void find (int[] start, int[][] land) {
        Queue<int[]> q = new ArrayDeque();
        q.offer(start);
        
        visited[start[0]][start[1]] = true;
        
        Set<Integer> set = new HashSet();
        set.add(start[1]);
        
        int count = 1;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + deltas[d][0];
                int nc = cur[1] + deltas[d][1];
                
                if (isIn(nr, nc) && !visited[nr][nc] && land[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                    set.add(nc);
                    count++;
                }
            }
        }
        
        for (int num : set) {
            amount[num] += count;
        }
    }
    
    public boolean isIn (int r, int c) {
        return r >= 0 && r < R && c >= 0 && c < C;
    }
}