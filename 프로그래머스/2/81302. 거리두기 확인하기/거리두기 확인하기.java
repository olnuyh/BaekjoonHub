import java.util.*;

class Solution {
    public int[][] deltas = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for (int i = 0; i < answer.length; i++) {
            char[][] room = new char[5][5];
            
            for (int j = 0; j < 5; j++) {
                room[j] = places[i][j].toCharArray();
            }

            if (check(room)) {
                answer[i] = 1;
            }
        }
        return answer;
    }
    
    public boolean check (char[][] room) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (room[i][j] == 'P') {
                    for (int d = 0; d < 4; d++) {
                        int nr = i + deltas[d][0];
                        int nc = j + deltas[d][1];
                        
                        if (!isIn(nr, nc) || room[nr][nc] == 'X') {
                            continue;
                        }
                        
                        if (room[nr][nc] == 'P') {
                            return false;
                        }
                        
                        for (int k = 0; k < 4; k++) {
                            if ((d + 2) % 4 == k) {
                                continue;
                            }
                            
                            nr = i + deltas[d][0] + deltas[k][0];
                            nc = j + deltas[d][1] + deltas[k][1];
                            
                            if (isIn(nr, nc) && room[nr][nc] == 'P') {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        
        return true;
    }
    
    public boolean isIn (int r, int c) {
        return r >= 0 && r < 5 && c >= 0 && c < 5;
    }
}