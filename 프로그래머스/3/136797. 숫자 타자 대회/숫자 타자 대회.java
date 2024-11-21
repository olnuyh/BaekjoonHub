import java.util.*;

class Solution {
    public int[][] weight = {{1, 7, 6, 7, 5, 4, 5, 3, 2, 3},
                             {7, 1, 2, 4, 2, 3, 5, 4, 5, 6},
                             {6, 2, 1, 2, 3, 2, 3, 5, 4, 5},
                             {7, 4, 2, 1, 5, 3, 2, 6, 5, 4},
                             {5, 2, 3, 5, 1, 2, 4, 2, 3, 5},
                             {4, 3, 2, 3, 2, 1, 2, 3, 2, 3},
                             {5, 5, 3, 2, 4, 2, 1, 5, 3, 2},
                             {3, 4, 5, 6, 2, 3, 5, 1, 2, 4},
                             {2, 5, 4, 5, 3, 2, 3, 2, 1, 2},
                             {3, 6, 5, 4, 5, 3, 2, 4, 2, 1}};
    
    public String nums;
    public int len;
    public int[][][] D;
    
    public int solution(String numbers) {
        nums = numbers;
        len = nums.length();
        
        D = new int[len][10][10];
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 10; j++) {
                Arrays.fill(D[i][j], Integer.MAX_VALUE);
            }
        }
        
        return move(0, 4, 6);
    }
    
    public int move (int depth, int left, int right) {
        if (depth == len) {
            return 0;
        }
        
        if (D[depth][left][right] != Integer.MAX_VALUE) {
            return D[depth][left][right];
        }
        
        int target = nums.charAt(depth) - '0';
        
        if (right != target) {
            D[depth][left][right] = Math.min(D[depth][left][right], move(depth + 1, target, right) + weight[left][target]);
        }
        
        if (left != target) {
            D[depth][left][right] = Math.min(D[depth][left][right], move(depth + 1, left, target) + weight[right][target]);
        }
        
        return D[depth][left][right];
    }
}