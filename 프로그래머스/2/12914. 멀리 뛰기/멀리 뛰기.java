class Solution {
    public long solution(int n) {
        long[] D = new long[n + 1];
        D[0] = 1;
        D[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            D[i] = (D[i - 1] + D[i - 2]) % 1234567;
        }
        
        return D[n];
    }
}