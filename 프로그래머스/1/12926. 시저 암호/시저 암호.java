class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        
        char[] alphabets = s.toCharArray();
        
        for (int i = 0; i < alphabets.length; i++) {
            char origin = alphabets[i];
            
            if (origin == ' ') {
                sb.append(origin);
                continue;
            }
            
            if (origin - 'a' < 0) {
                sb.append((char)((origin + n - 'A') % 26 + 'A'));
            } else {
                sb.append((char)((origin + n - 'a') % 26 + 'a'));
            }
        }
        
        return sb.toString();
    }
}