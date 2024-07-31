import java.util.*;

class Solution {
    public static ArrayList<Integer> list;
    public static char[] nums;
    public static boolean[] selected;
    
    public int solution(String numbers) {
        nums = numbers.toCharArray();
        list = new ArrayList();
        
        selected = new boolean[numbers.length()];
        makeNumber("", 0);
        
        return list.size();
    }
    
    public void makeNumber(String cur, int idx) {
        if (idx == selected.length) {
            if (cur.equals("")) {
                return;
            }
            
            int num = Integer.parseInt(cur);
            
            if (check(num) && !list.contains(num)) {
                list.add(num);
            }
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!selected[i]) {
                selected[i] = true;
                makeNumber(cur + nums[i], idx + 1);
                selected[i] = false;
                makeNumber(cur, idx + 1);     
            } 
        }
    }
    
    public boolean check(int number) {
        if (number <= 1) {
            return false;
        }
        
        for (int i = 2; i <= (int)Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}