class Solution {
    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0};
    
    private boolean isNextPerson(char[][] room, int r, int c, int exclude)
    {
        for(int d = 0; d < 4; d++)
        {
            if(d == exclude)
                continue;
            
            int next_r = r + dr[d];
            int next_c = c + dc[d];
            
            if(next_r >= 0 && next_r < 5 && next_c >= 0 && next_c < 5)
            {
                if(room[next_r][next_c] == 'P')
                    return true;
            }
        }
        return false;
    }
    
    private boolean isOk(char[][] room, int r, int c)
    {
        for(int d = 0; d < 4; d++)
        {
            int next_r = r + dr[d];
            int next_c = c + dc[d];
            
            if(next_r >= 0 && next_r < 5 && next_c >= 0 && next_c < 5)
            {
                switch(room[next_r][next_c])
                {
                    case 'P':
                        return false;
                    case 'O':
                        if(isNextPerson(room, next_r, next_c, 3 - d))
                            return false;
                        break;
                }
            }
        }
        return true;
    }
    
    private boolean isOk(char[][] room)
    {
        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                if(room[i][j] == 'P')
                {
                    if(!isOk(room, i, j))
                        return false;
                }
            }
        }
        return true;
    }
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for(int i = 0; i < 5; i++)
        {
            String[] place = places[i];
            char[][] room = new char[5][];
            for(int j = 0; j < 5; j++)
                room[j] = place[j].toCharArray();
            if(isOk(room))
                answer[i] = 1;
            else
                answer[i] = 0;
        }
        return answer;
    }
}