import java.util.*;

class Solution {
    public static String[] order = {"*-+", "*+-", "-+*", "-*+", "+*-", "+-*"};
    
    public long solution(String expression) {
        long answer = 0;
        
        StringTokenizer st = new StringTokenizer(expression, "*-+", true);
        
        ArrayList<String> list = new ArrayList();
        
        while (st.hasMoreTokens()) {
            list.add(st.nextToken());
        }
        
        for (int i = 0; i < order.length; i++) {
            ArrayList<String> listClone = new ArrayList(list);
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < listClone.size(); k++) {
                    if (listClone.get(k).equals(order[i].substring(j, j + 1))) {
                        long result = calculate(Long.parseLong(listClone.get(k - 1)), Long.parseLong(listClone.get(k + 1)), listClone.get(k).charAt(0));
                        listClone.remove(k - 1);
                        listClone.remove(k - 1);
                        listClone.remove(k - 1);
                        listClone.add(k - 1, Long.toString(result));
                        k -= 2;
                    }
                }
            }
            
            answer = Math.max(answer, Math.abs(Long.parseLong(listClone.get(0))));
        }
        
        return answer;
    }
    
    public long calculate(long a, long b, char operand) {
        switch (operand) {
            case '+' :
                return a + b;
            case '-' :
                return a - b;
            case '*' :
                return a * b;
        }
        
        return 0;
    }
}