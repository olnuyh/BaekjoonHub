class Solution {
    boolean solution(String s) {
        s = s.toUpperCase();
        
        int pCnt = count(s, 'P');
        int yCnt = count(s, 'Y');
        
        return pCnt == yCnt;
    }
    
    int count (String s, char c) {
        int cnt = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                cnt++;
            }
        }
        
        return cnt;
    }
}