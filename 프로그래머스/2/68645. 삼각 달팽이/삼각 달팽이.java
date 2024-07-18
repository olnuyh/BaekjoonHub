class Solution {
    public int[][] deltas = {{1, 0}, {0, 1}, {-1, -1}};
    
    public int[] solution(int n) {
        int[][] arr = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        
        int r = 0;
        int c = 0;
        int d = 0;
        int num = 1;
        int cnt = 0;
        
        while (cnt < 2) {
            if (r < 0 || r >= n || c < 0 || c >= n || visited[r][c]) {
                r -= deltas[d][0];
                c -= deltas[d][1];
                d = (d + 1) % 3;
                r += deltas[d][0];
                c += deltas[d][1];
                cnt++;
            } else {
                arr[r][c] = num++;
                visited[r][c] = true;
                r += deltas[d][0];
                c += deltas[d][1];
                cnt = 0;
            }
        }
        
        int[] answer = new int[num - 1];
        
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[idx++] = arr[i][j];
            }
        }
        
        return answer;
    }
}