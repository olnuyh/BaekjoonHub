import java.util.HashMap;
class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] dw = {0, 1, 0, -1};
        int[] dh = {-1, 0, 1, 0};
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("N", 0);
        hm.put("E", 1);
        hm.put("S", 2);
        hm.put("W", 3);
        
        char[][] map = new char[park.length][park[0].length()];
        int start_h = 0;
        int start_w = 0;
        
        for(int i = 0; i < park.length; i++)
        {
            for(int j = 0; j < park[0].length(); j++)
            {
                map[i][j] = park[i].charAt(j);
                if(park[i].charAt(j) == 'S')
                {
                    start_h = i;
                    start_w = j;
                }
            }
        }
        
        for(int i = 0; i < routes.length; i++)
        {
            String[] tmp = routes[i].split(" ");
            int now_h = start_h;
            int now_w = start_w;
            boolean isAvailable = true;
            for(int j = 0; j < Integer.parseInt(tmp[1]); j++)
            {
                int next_h = now_h + dh[hm.get(tmp[0])];
                int next_w = now_w + dw[hm.get(tmp[0])];
                if(next_h < 0 || next_h >= park.length || next_w < 0 || next_w >= park[0].length() || map[next_h][next_w] == 'X')
                {
                    isAvailable = false;
                    break;
                }
                else{
                    now_h = next_h;
                    now_w = next_w;
                }
            }
            
            if(isAvailable)
            {
                start_h = now_h;
                start_w = now_w;   
            }
        }
        
        int[] answer = new int[2];
        answer[0] = start_h;
        answer[1] = start_w;
        return answer;
    }
}