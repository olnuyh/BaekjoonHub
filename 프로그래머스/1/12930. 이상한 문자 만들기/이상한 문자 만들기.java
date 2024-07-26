class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        String[] words = s.split(" ", -1);
        
        for (String word : words) {
            if (word.equals(" ")) {
                sb.append(" ");
                continue;
            }
            
            for (int i = 0; i < word.length(); i++) {
                char cur = word.charAt(i);
                if (i % 2 == 0) {
                    if (cur >= 'A' && cur <= 'Z') {
                        sb.append(cur);
                        continue;
                    }
                    
                    sb.append((char)(cur - ('a' - 'A')));
                } else {
                    if (cur >= 'a' && cur <= 'z') {
                        sb.append(cur);
                        continue;
                    }
                    
                    sb.append((char)(cur + ('a' - 'A')));
                }
            }
            
            sb.append(" ");
        }
        
        sb.deleteCharAt(sb.length() - 1);
        
        return sb.toString();
    }
}