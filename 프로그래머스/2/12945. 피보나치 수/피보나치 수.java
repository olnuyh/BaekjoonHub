class Solution {
    public int solution(int n) {

        int[] D = new int[100001];
        D[0] = 0;
        D[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            D[i] = (D[i - 2] + D[i - 1]) % 1234567;
        }
        
        return D[n];
    }
}