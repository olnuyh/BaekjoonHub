class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        String[] words = s.split(" ", -1);
        
        for (String str : words) {
            if (!str.equals("")) {
                str = str.toLowerCase();
                str = str.substring(0, 1).toUpperCase() + str.substring(1, str.length());
                sb.append(str);
            }
            
            sb.append(" ");           
        }
        
        sb.deleteCharAt(sb.length() - 1);
        
        return sb.toString();
    }
}