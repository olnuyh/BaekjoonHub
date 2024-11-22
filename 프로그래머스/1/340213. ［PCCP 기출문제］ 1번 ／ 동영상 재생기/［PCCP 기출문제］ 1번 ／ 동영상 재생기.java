class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        int cur = change(pos);
        
        if (cur >= change(op_start) && cur <= change(op_end)) {
            cur = change(op_end);
        }
        
        for (String cmd : commands) {
            if (cmd.equals("prev")) {
                cur = Math.max(cur - 10, 0);
            } else {
                cur = Math.min(cur + 10, change(video_len));
            }
            
            if (cur >= change(op_start) && cur <= change(op_end)) {
                cur = change(op_end);
            }
        }
        
        answer += cur / 60 >= 10 ? cur / 60 : "0" + (cur / 60);
        answer += ":";
        answer += cur % 60 >= 10 ? cur % 60 : "0" + (cur % 60);
        
        return answer;
    }
    
    public int change (String str) {
        String[] s = str.split(":");
        
        return Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
    }
}