class Solution {
    public int maxScore;
    public int[] answer;
    
    public int[] solution(int n, int[] info) {
        maxScore = 0;
        answer = new int[11];
        shoot(0, n, new int[11], info);
        
        if (maxScore != 0) {
            return answer;
        }
        
        return new int[]{-1};
    }
    
    public void shoot (int idx, int n, int[] ryan, int[] apeach) {
        if (idx == n) {
            
            int rScore = 0;
            int aScore = 0;
            
            for (int i = 0; i < 11; i++) {
                if (apeach[i] == 0 && ryan[i] == 0) {
                    continue;
                }
                
                if (ryan[i] > apeach[i]) {
                    rScore += 10 - i;
                } else {
                    aScore += 10 - i;
                }
            }
            
            int result = rScore - aScore;
            
            if (result > 0 && result >= maxScore) {
                maxScore = result;
                answer = ryan.clone();
            }
            
            return;
        }
        
        for (int i = 0; i < 11 && ryan[i] <= apeach[i]; i++) {         
            ryan[i]++;
            shoot(idx + 1, n, ryan, apeach);
            ryan[i]--;
        }
    }
}