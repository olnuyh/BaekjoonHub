import java.util.*;

class Solution {
    public ArrayList<long[]> interPoints = new ArrayList();
    public static long[] minXY = {Long.MAX_VALUE, Long.MAX_VALUE};
    public static long[] maxXY = {Long.MIN_VALUE, Long.MIN_VALUE};
    
    public String[] solution(int[][] line) {
        
        for (int i = 0; i < line.length - 1; i++) {
            for (int j = i + 1; j < line.length; j++) {
                long[] lineA = new long[]{line[i][0], line[i][1], line[i][2]};
                long[] lineB = new long[]{line[j][0], line[j][1], line[j][2]};
                
                if (lineA[0] * lineB[1] - lineA[1] * lineB[0] == 0) {
                    continue;
                }
                
                findInterPoint(lineA, lineB);
            }
        }
        
        char[][] result = new char[(int)(maxXY[1] - minXY[1] + 1)][(int)(maxXY[0] - minXY[0] + 1)];
        for (int i = 0; i < result.length; i++) {
            Arrays.fill(result[i], '.');
        }
        
        for (long[] point : interPoints) {
            result[(int)(maxXY[1] - point[1])][(int)(point[0] - minXY[0])] = '*';
        }
        
        String[] answer = new String[result.length];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = String.valueOf(result[i]);
        }
        
        return answer;
    }
    
    public void findInterPoint (long[] lineA, long[] lineB) {
        double x = (double)(lineA[1] * lineB[2] - lineA[2] * lineB[1]) / (double)(lineA[0] * lineB[1] - lineA[1] * lineB[0]);
        double y = (double)(lineA[2] * lineB[0] - lineA[0] * lineB[2]) / (double)(lineA[0] * lineB[1] - lineA[1] * lineB[0]);

        if (x % 1 == 0.0 && y % 1 == 0.0) {
            long curX = (long)x;
            long curY = (long)y;
            
            minXY[0] = Math.min(minXY[0], curX);
            maxXY[0] = Math.max(maxXY[0], curX);
            minXY[1] = Math.min(minXY[1], curY);
            maxXY[1] = Math.max(maxXY[1], curY);
            
            interPoints.add(new long[]{(long)x, (long)y});
        }
    }
}