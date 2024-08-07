class Solution {
    public int solution(int[][] dots) {
        if (getGradient(dots[0], dots[1]) == getGradient(dots[2], dots[3])) {
            return 1;
        }
        
        if (getGradient(dots[0], dots[2]) == getGradient(dots[1], dots[3])) {
            return 1;
        }
        
        if (getGradient(dots[0], dots[3]) == getGradient(dots[1], dots[2])) {
            return 1;
        }
        
        return 0;
    }
    
    public double getGradient(int[] pos1, int[] pos2) {
        return (double) (pos2[1] - pos1[1]) / (pos2[0] - pos1[0]);
    }
}