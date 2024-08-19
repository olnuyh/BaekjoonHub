import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {        
        return bfs(begin, target, words);
    }
    
    public int bfs(String begin, String target, String[] words) {
        Queue<String> q = new ArrayDeque();
        q.offer(begin);
        boolean[] visited = new boolean[words.length];
        
        int cnt = 0;
        
        while (!q.isEmpty()) {
            int size = q.size();
            
            while (--size >= 0) {
                String cur = q.poll();
            
                if (cur.equals(target)) {
                    return cnt;
                }   
                
                for (int i = 0; i < words.length; i++) {
                    if(!visited[i] && canGo(cur, words[i])) {
                        q.offer(words[i]);
                        visited[i] = true;
                    }
                }
            }
         
            cnt++;
        }
        
        return 0;
    }
    
    public boolean canGo (String a, String b) {
        int cnt = 0;
        
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                cnt++;
            }
        }
        
        if (cnt == 1) {
            return true;
        } else {
            return false;
        }
    }
}