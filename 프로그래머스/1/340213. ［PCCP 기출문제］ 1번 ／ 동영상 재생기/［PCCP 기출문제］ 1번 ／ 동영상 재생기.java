class Solution {
    public String answer;
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        answer = "";
        
        int cur = change(pos);
        
        for (String cmd : commands) {
            if (cur >= change(op_start) && cur <= change(op_end)) {
                cur = change(op_end);
            }
            
            if (cmd.equals("prev")) {
                cur = Math.max(cur - 10, 0);
            } else {
                cur = Math.min(cur + 10, change(video_len));
            }
            
            if (cur >= change(op_start) && cur <= change(op_end)) {
                cur = change(op_end);
            }
        }
        
        changeToStr(cur);
        
        return answer;
    }
    
    public int change (String str) {
        String[] s = str.split(":");
        
        return Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
    }
    
    public void changeToStr (int cur) {
        if (cur / 60 >= 10) {
            answer += cur / 60;
        } else {
            answer += "0" + (cur / 60);
        }
        
        answer += ":";
        
        if (cur % 60 >= 10) {
            answer += cur % 60;
        } else {
            answer += "0" + (cur % 60);
        }
    }
}