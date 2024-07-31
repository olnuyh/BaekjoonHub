import java.util.*;

class Solution {
    public static String[] ban;
    public static boolean[] visited;
    public static Set<String> set;
    
    public int solution(String[] user_id, String[] banned_id) {        
        ban = new String[banned_id.length];
        
        for (int i = 0; i < ban.length; i++) {
            ban[i] = banned_id[i].replace("*", ".");
        }
        
        visited = new boolean[user_id.length];
        set = new HashSet();
        
        makeList(user_id, 0, new String[ban.length]);
        
        return set.size();
    }
    
    public void makeList(String[] user_id, int cnt, String[] list) {
        if (cnt == ban.length) {
            
            for (int i = 0; i < list.length; i++) {
                if (!list[i].matches(ban[i])) {
                    return;
                }
            }
            
            String[] listClone = Arrays.copyOf(list, list.length);
            
            Arrays.sort(listClone);
            
            String str = "";
            for (String s : listClone) {
                str += s;
            }
            
            set.add(str);
            
            return;
        }
        
        for (int i = 0; i < user_id.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list[cnt] = user_id[i];
                makeList(user_id, cnt + 1, list);  
                visited[i] = false;
            }
        }
    }
}