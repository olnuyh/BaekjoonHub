class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        int[][] D = new int[triangle.length][triangle.length];
        
        D[0][0] = triangle[0][0];
        
        for (int i = 0; i < triangle.length - 1; i++) {
            for (int j = 0; j <= i; j++) {
                D[i + 1][j] = Math.max(D[i + 1][j], D[i][j] + triangle[i + 1][j]);
                D[i + 1][j + 1] = Math.max(D[i + 1][j + 1], D[i][j] + triangle[i + 1][j + 1]);
            }
        }
        
        for (int i = 0; i < triangle.length; i++) {
            answer = Math.max(answer, D[triangle.length - 1][i]);
        }
        
        return answer;
    }
}