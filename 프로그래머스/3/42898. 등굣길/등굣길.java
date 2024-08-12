class Solution {
    public int solution(int m, int n, int[][] puddles) {
        
        int[][] D = new int[n][m];
        for (int i = 0; i < puddles.length; i++) {
            int[] pos = puddles[i];
            
            D[pos[1] - 1][pos[0] - 1] = -1;
        }
        
        D[0][0] = 1;
        
//         for (int i = 0; i < n; i++) {
//             if (D[i][0] != -1) {
//                 D[i][0] = 1;
//             }
//         }
        
//         for (int i = 0; i < m; i++) {
//             if (D[0][i] != -1) {
//                 D[0][i] = 1;
//             }
//         }
        
        for (int i = 0; i < n; i++) {            
            for (int j = 0; j < m; j++) {
                if (D[i][j] == -1) {
                    continue;
                }
                
                if (i >= 1 && D[i - 1][j] != -1){
                    D[i][j] += D[i - 1][j];
                }
                
                if (j >= 1 && D[i][j - 1] != -1) {
                    D[i][j] += D[i][j - 1];
                }
                
                if (D[i][j] > 1000000007) {
                    D[i][j] %= 1000000007;
                }
            }
        }
        
        return D[n - 1][m - 1];
    }
}