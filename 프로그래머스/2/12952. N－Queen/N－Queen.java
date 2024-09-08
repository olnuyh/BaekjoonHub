class Solution {
    public boolean[] colCheck;
    public boolean[] rDiagCheck;
    public boolean[] lDiagCheck;
    
    public int answer;
    
    public int solution(int n) {
        answer = 0;
        
        colCheck = new boolean[n];
        rDiagCheck = new boolean[2 * n];
        lDiagCheck = new boolean[2 * n];
        
        dfs(0, n);
        
        return answer;
    }
    
    public void dfs(int k, int n) {
        if (k == n) {
            answer++;
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if(!colCheck[i] && !rDiagCheck[k + i] && !lDiagCheck[k - i + n]) {
                colCheck[i] = true;
                rDiagCheck[k + i] = true;
                lDiagCheck[k - i + n] = true;
                dfs(k + 1, n);
                colCheck[i] = false;
                rDiagCheck[k + i] = false;
                lDiagCheck[k - i + n] = false;
            }
        }
    }
}