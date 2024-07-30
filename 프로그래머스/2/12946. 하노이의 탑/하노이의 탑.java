import java.util.*;

class Solution {
    public static ArrayList<int[]> list;
    
    public int[][] solution(int n) {
        
        list = new ArrayList();
        
        hanoi(n, 1, 3, 2);
        
        int[][] answer = new int[list.size()][2];
        
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    public void hanoi(int num, int start, int end, int mid) {
        if (num == 0) {
            return;
        }
        
        hanoi(num - 1, start, mid, end);
        list.add(new int[]{start, end});
        hanoi(num - 1, mid, end, start);
    }
}