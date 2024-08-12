class Solution {
    public static int[] init = {Integer.MAX_VALUE, Integer.MIN_VALUE};
    public static int[][][] D;
    
    public int solution(String arr[]) {
        D = new int[2][210][210];
        
        for (int i = 0; i < 210; i++) {
            for (int j = 0; j < 210; j++) {
                D[0][i][j] = Integer.MAX_VALUE;
                D[1][i][j] = Integer.MIN_VALUE;
            }
        }
        
        return calculate(1, 0, arr.length, arr);
    }
    
    public int calculate(int type, int start, int end, String[] arr) {
        if (end - start == 1) {
            return D[type][start][end] = Integer.parseInt(arr[start]);
        }
        
        if (D[type][start][end] != init[type]) {
            return D[type][start][end];
        }
        
        int result = init[type];
        
        if (type == 0) {
            for (int i = start + 1; i < end; i += 2) {
                int l = calculate(type, start, i, arr);
                
                if (arr[i].equals("+")) {
                    result = Math.min(result, l + calculate(type, i + 1, end, arr));
                } else {
                    result = Math.min(result, l - calculate(1 - type, i + 1, end, arr));
                }
            }
        } else {
            for (int i = start + 1; i < end; i += 2) {
                int l = calculate(type, start, i, arr);
                
                if (arr[i].equals("+")) {
                    result = Math.max(result, l + calculate(type, i + 1, end, arr));
                } else {
                    result = Math.max(result, l - calculate(1 - type, i + 1, end, arr));
                }
            }
        }
        
        return D[type][start][end] = result;
    }
}