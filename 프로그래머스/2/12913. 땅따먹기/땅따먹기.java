class Solution {
    int solution(int[][] land) {
        int[][] D = new int[land.length][land[0].length];
        for (int i = 0; i < land[0].length; i++) {
            D[0][i] = land[0][i];
        }
        
        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                for (int k = 0; k < land[i].length; k++) {
                    if (j == k) {
                        continue;
                    }
                    
                    D[i][j] = Math.max(D[i][j], land[i][j] + D[i - 1][k]);   
                }
            }
        }
        
        int answer = 0;

        for (int i = 0; i < land[0].length; i++) {
            answer = Math.max(answer, D[land.length - 1][i]);
        }

        return answer;
    }
}