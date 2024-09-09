import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        List<int[]> list = new ArrayList();
        for(int[] d : data) {
            list.add(d);
        }
        
        Collections.sort(list, (o1, o2) -> {
            if(o1[col - 1] == o2[col - 1]) {
                return o2[0] - o1[0];
            }
            return o1[col - 1] - o2[col - 1];
        });        
        
        int answer = 0;
        
        for(int i = row_begin - 1; i < row_end; i++) {
            int sum = 0;
            
            for(int j = 0; j < list.get(i).length; j++) {
                sum += list.get(i)[j] % (i + 1);
            }
            
            answer ^= sum;
        }
        
        return answer;
    }
}