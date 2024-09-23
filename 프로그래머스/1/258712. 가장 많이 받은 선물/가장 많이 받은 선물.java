import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
       int n = friends.length;
        
        HashMap<String, Integer> hm = new HashMap();
        for(int i = 0; i < n; i++) {
            hm.put(friends[i], i);
        }
        
        int[][] giveAndTake = new int[n][n];
        int[] score = new int[n];
        
        for(String gift : gifts) {
            String[] str = gift.split(" ");
            
            int give = hm.get(str[0]);
            int take = hm.get(str[1]);
            
            giveAndTake[give][take]++;
            score[give]++;
            score[take]--;
        }   
        
        int answer = 0;
        int[] result = new int[n];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j || giveAndTake[i][j] < giveAndTake[j][i]) {
                    continue;
                }
                
                if(giveAndTake[i][j] > giveAndTake[j][i]) {
                    result[i]++;
                } else {
                    if(score[i] > score[j]) {
                        result[i]++;
                    }
                }
                
                answer = Math.max(answer, result[i]);
            }
        }
        return answer;
    }
}