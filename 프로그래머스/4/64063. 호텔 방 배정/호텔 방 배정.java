import java.util.*;

class Solution {
    public static HashMap<Long, Long> hm;
    
    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        
        hm = new HashMap();
        
        for(int i = 0; i < room_number.length; i++) {
            long num = room_number[i];
            
            answer[i] = assignRoom(num);
        }
        
        return answer;
    }
    
    public long assignRoom (long num) {
        if (!hm.containsKey(num)) {
            hm.put(num, num + 1);
            
            return num;
        }
        
        long empty = assignRoom(hm.get(num));

        hm.put(num, empty);
        
        return empty;
    }
}