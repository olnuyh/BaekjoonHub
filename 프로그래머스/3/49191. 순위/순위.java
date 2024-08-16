class Solution {
    public int solution(int n, int[][] results) {
        int answer = n;
        
        int[][] contest = new int[n + 1][n + 1];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    continue;
                }
                
                contest[i][j] = n * n;
            }
        }
        
        for (int i = 0; i < results.length; i++) {
            int[] result = results[i];
            
            contest[result[0]][result[1]] = 1;
        }
        
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    contest[i][j] = Math.min(contest[i][j], contest[i][k] + contest[k][j]);
                }
            }
        }
        
        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    continue;
                }
                
                if (contest[i][j] == n * n && contest[j][i] == n * n) {
                    answer--;
                    break;
                }
            }
        }
        
        return answer;
    }
}