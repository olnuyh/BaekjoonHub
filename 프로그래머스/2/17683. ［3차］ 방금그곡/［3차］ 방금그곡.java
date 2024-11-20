class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        int runningTime = -1;
        
        m = change(m);
        
        for (String str : musicinfos) {
            String[] info = str.split(",");
            
            info[3] = change(info[3]);
            
            String[] start = info[0].split(":");
            String[] end = info[1].split(":");
            
            int time = (Integer.parseInt(end[0]) - Integer.parseInt(start[0])) * 60 + (Integer.parseInt(end[1]) - Integer.parseInt(start[1]));
            int len = info[3].length();
            
            String total = "";
            
            for (int i = 1; i <= time / len; i++) {
                total += info[3];
            }
            
            total += info[3].substring(0, time % len);
            
            if (total.contains(m) && runningTime < time) {
                answer = info[2];
                runningTime = time;
            }
        }
        
        if (runningTime == -1) {
            answer = "(None)";
        }
        
        return answer;
    }
    
    public String change (String m) {
        m = m.replaceAll("A#", "a");
        m = m.replaceAll("B#", "b");
        m = m.replaceAll("C#", "c");
        m = m.replaceAll("D#", "d");
        m = m.replaceAll("E#", "e");
        m = m.replaceAll("F#", "f");
        m = m.replaceAll("G#", "g");
        
        return m;
    }
}