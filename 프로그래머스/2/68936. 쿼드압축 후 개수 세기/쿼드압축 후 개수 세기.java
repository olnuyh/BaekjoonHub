class Solution {
    public static int zero;
    public static int one;
    
    public int[] solution(int[][] arr) {
        zero = 0;
        one = 0;
        
        compress(arr, 0, 0, arr.length);
        
        return new int[]{zero, one};
    }
    
    public void compress(int[][] arr, int sr, int sc, int len) {        
        int sum = 0;
        
        for (int i = sr; i < sr + len; i++) {
            for (int j = sc; j < sc + len; j++) {
                sum += arr[i][j];
            }
        }
        
        if (sum == 0) {
            zero++;
        } else if (sum == len * len) {
            one++;
        } else {
            compress(arr, sr, sc, len / 2);
            compress(arr, sr + len / 2, sc, len / 2);
            compress(arr, sr, sc + len / 2, len / 2);
            compress(arr, sr + len / 2, sc + len / 2, len / 2);
        }
    }
}