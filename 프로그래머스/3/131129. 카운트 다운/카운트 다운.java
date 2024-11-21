import java.util.Arrays;

public class Solution {
    public int[] solution(int target) {

        int[][] dp = new int[target + 1][2]; 
        
        for (int i = 1; i <= target; i++) {
            dp[i][0] = Integer.MAX_VALUE; 
        }

        int[] scores = new int[62];
        int index = 0;
        for (int i = 1; i <= 20; i++) {
            scores[index++] = i;
            scores[index++] = i * 2;
            scores[index++] = i * 3;
        }
        scores[index] = 50;

        for (int i = 0; i <= target; i++) {
            for (int score : scores) {
                if (i >= score) {

                    int darts = dp[i - score][0] + 1;

                    int singles = dp[i - score][1];
                    if (score <= 20) {
                        singles += 1;
                    } else if (score == 50) {
                        singles += 1;
                    }

                    if (darts < dp[i][0]) {
                        dp[i][0] = darts;
                        dp[i][1] = singles;
                    } else if (darts == dp[i][0] && singles > dp[i][1]) {
                        dp[i][1] = singles;
                    }
                }
            }
        }

        return dp[target];
    }
}