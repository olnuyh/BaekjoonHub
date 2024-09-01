class Solution {
    public int solution(int n) {
        int[] D = new int[n + 1];
        D[0] = 1;
        D[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            D[i] = (D[i - 2] + D[i - 1]) % 1000000007;
        }
        
        return D[n];
    }
}