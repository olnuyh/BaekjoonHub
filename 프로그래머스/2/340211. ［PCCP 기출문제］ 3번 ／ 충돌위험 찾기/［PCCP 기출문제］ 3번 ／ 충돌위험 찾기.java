import java.util.*;

class Solution {
    public static List<int[]>[] ways;
    
    public int solution(int[][] points, int[][] routes) {
        ways = new ArrayList[routes.length];
        
        for (int i = 0; i < ways.length; i++) {
            ways[i] = new ArrayList();
        }
        
        int maxWay = 0;
        
        for (int i = 0; i < routes.length; i++) {
            int count = 0;
            
            for (int j = 0; j < routes[i].length - 1; j++) {
                int sr = points[routes[i][j] - 1][0] - 1;
                int sc = points[routes[i][j] - 1][1] - 1;
            
                int er = points[routes[i][j + 1] - 1][0] - 1;
                int ec = points[routes[i][j + 1] - 1][1] - 1;   
                
                count += move(i, new int[]{sr, sc}, new int[]{er, ec});
            }
            
            int fr = points[routes[i][routes[i].length - 1] - 1][0] - 1;
            int fc = points[routes[i][routes[i].length - 1] - 1][1] - 1;
            
            ways[i].add(new int[]{fr, fc});
            count++;
            
            maxWay = Math.max(maxWay, count);
        }
        
        int answer = 0;
        
        for (int i = 0; i < maxWay; i++) {
            int[][] check = new int[101][101];
            
            for (int j = 0; j < routes.length; j++) {
                if (ways[j].size() < i + 1) {
                    continue;
                }
                
                int[] cur = ways[j].get(i);
                check[cur[0]][cur[1]]++;
            }
            
            for (int j = 0; j <= 100; j++) {
                for (int k = 0; k <= 100; k++) {
                    if (check[j][k] > 1) {
                        answer++;
                    }
                }
            }
        }
        
        return answer;
    }
     
    public int move(int robot, int[] start, int[] end) {
        int count = 0;
        
        if (start[0] < end[0]) {
            while (start[0] < end[0]) {
                ways[robot].add(new int[]{start[0], start[1]});
                start[0]++;
                count++;
            }
        } else if (start[0] > end[0]) {
            while (start[0] > end[0]) {
                ways[robot].add(new int[]{start[0], start[1]});
                start[0]--;
                count++;
            }
        }
        
        if (start[1] < end[1]) {
            while (start[1] < end[1]) {
                ways[robot].add(new int[]{start[0], start[1]});
                start[1]++;
                count++;
            }
        } else if (start[1] > end[1]) {
            while (start[1] > end[1]) {
                ways[robot].add(new int[]{start[0], start[1]});
                start[1]--;
                count++;
            }
        }
        
        return count;
    }
}