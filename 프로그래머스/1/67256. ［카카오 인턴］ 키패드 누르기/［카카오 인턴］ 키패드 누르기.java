class Solution {  
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        
        int left = 10;
        int right = 12;
        
        for (int num : numbers) {
            if (num == 1 || num == 4 || num == 7) {
                sb.append("L");
                left = num;
            } else if (num == 3 || num == 6 || num == 9) {
                sb.append("R");
                right = num;
            } else {
                if (num == 0) {
                    num = 11;
                }
                
                int lDistance = Math.abs((left - 1) / 3 - (num - 1) / 3) + Math.abs((left - 1) % 3 - (num - 1) % 3);
                int rDistance = Math.abs((right - 1) / 3 - (num - 1) / 3) + Math.abs((right - 1) % 3 - ((num - 1) % 3));
                         
                if (lDistance < rDistance) {
                    sb.append("L");
                    left = num;
                } else if (lDistance > rDistance) {
                    sb.append("R");
                    right = num;
                } else {
                    if (hand.equals("left")) {
                        sb.append("L");
                        left = num;
                    } else {
                        sb.append("R");
                        right = num;
                    }
                }
            }
        }
        return sb.toString();
    }
}