import java.util.*;

class Solution {
    public String[] solution(String[] record) {        
        Map<String, String> map = new HashMap();
        
        int count = 0;
        
        for (String s : record) {
            String[] cmd = s.split(" ");
            if (cmd[0].equals("Enter") || cmd[0].equals("Change")) {
                map.put(cmd[1], cmd[2]);
            }
            
            if (cmd[0].equals("Enter") || cmd[0].equals("Leave")) {
                count++;
            }
        }
        
        String[] answer = new String[count];
        
        int idx = 0;
        
        for (String s : record) {
            String[] cmd = s.split(" ");
            
            if (cmd[0].equals("Enter")) {
                answer[idx++] = map.get(cmd[1]) + "님이 들어왔습니다.";
            } else if (cmd[0].equals("Leave")) {
                answer[idx++] = map.get(cmd[1]) + "님이 나갔습니다.";
            }
        }
        
        return answer;
    }
}