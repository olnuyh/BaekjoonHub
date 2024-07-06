import java.util.*;

class Solution {
    public char[] chars;
    public HashSet<Integer> hs;
    public boolean[] visited;
    
    public int solution(String numbers) {
        chars = numbers.toCharArray();
        hs = new HashSet();
        visited = new boolean[numbers.length()];
        
        makeNum("", 0);
        return hs.size();
    }
    
    public void makeNum(String cur, int cnt) {
        if (cnt == visited.length) {
            if (cur.equals("")) {
                return;
            }
            
            int num = Integer.parseInt(cur);
            
            if (check(num)) {
                hs.add(num);
            }
            
            return;
        }
        
        for (int i = 0; i < chars.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                makeNum(cur + chars[i], cnt + 1);
                visited[i] = false;
                makeNum(cur, cnt + 1);
            }
        }
    }
    
    public boolean check(int num) {
        if (num < 2) {
            return false;
        }        
        
        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}