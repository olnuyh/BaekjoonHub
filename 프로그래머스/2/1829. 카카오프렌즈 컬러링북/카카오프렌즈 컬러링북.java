import java.util.*;

class Solution {
    public int rSize, cSize;
    public boolean[][] visited;
    public int[][] deltas = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    public int[] solution(int m, int n, int[][] picture) {
        rSize = m;
        cSize = n;
        
        visited = new boolean[rSize][cSize];
        
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        for (int i = 0; i < rSize; i++) {
            for (int j = 0; j < cSize; j++) {
                if (picture[i][j] > 0 && !visited[i][j]) {
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, paint(i, j, picture[i][j], picture));
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    public int paint(int r, int c, int color, int[][] picture) {
        Queue<int[]> q = new ArrayDeque();
        q.offer(new int[]{r, c});
        
        visited[r][c] = true;
        
        int count = 1;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + deltas[d][0];
                int nc = cur[1] + deltas[d][1];
                
                if(isIn(nr, nc) && picture[nr][nc] == color && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                    count++;
                }
            }
        }
        
        return count;
    }
    
    public boolean isIn(int r, int c) {
        return r >= 0 && r < rSize && c >= 0 && c < cSize;
    }
}