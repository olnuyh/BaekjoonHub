class Solution {
    public int solution(int n) {
        int original = count(n);
        
        for (int i = n + 1; ; i++) {
            if (original == count(i)) {
                return i;
            }
        }
    }
    
    public int count(int n) {
        int cnt = 0;
        
        char[] arr = Integer.toString(n, 2).toCharArray();
        
        for (char c : arr) {
            if (c == '1') {
                cnt++;
            }
        }
        
        return cnt;
    }
}