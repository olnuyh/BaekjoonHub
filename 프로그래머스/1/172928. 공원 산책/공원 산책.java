class Solution {
    public int[][] deltas = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public int n, m;
    
    public int[] solution(String[] park, String[] routes) {
        n = park.length;
        m = park[0].length();
        
        int[] position = new int[2];
        
        char[][] map = new char[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = park[i].charAt(j);
                if (map[i][j] == 'S') {
                    position[0] = i;
                    position[1] = j;
                }
            }
        }
        
        for (String s : routes) {
            String[] command = s.split(" ");
            int num = Integer.parseInt(command[1]);
            
            int d = -1;
            
            switch(command[0]) {
                case "N":
                    d = 0;
                    break;
                case "E":
                    d = 1;
                    break;
                case "S":
                    d = 2;
                    break;
                case "W":
                    d = 3;
                    break;
            }
            
            boolean isPossible = true;
            
            for (int i = 1; i <= num; i++) {
                int nr = position[0] + deltas[d][0] * i;
                int nc = position[1] + deltas[d][1] * i;
                
                if (!isIn(nr, nc) || map[nr][nc] == 'X') {
                    isPossible = false;
                    break;
                }
            }
            
            if (isPossible) {
                position[0] += deltas[d][0] * num;
                position[1] += deltas[d][1] * num;
            }
        }
        
        return position;
    }
    
    public boolean isIn(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }
}