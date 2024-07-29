class Solution {
    public int[] solution(String s) {
        String str = s;
        
        int change = 0;
        int zero = 0;
        
        while (!str.equals("1")) {            
            String newStr = str.replace("0", "");
            zero += str.length() - newStr.length();
            str = Integer.toString(newStr.length(), 2);
            change++;
        }
        
        return new int[]{change, zero};
    }
}