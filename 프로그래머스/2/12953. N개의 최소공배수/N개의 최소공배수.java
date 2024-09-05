class Solution {
    public int solution(int[] arr) {
        int answer = 1;
        
        for (int i = 0; i < arr.length; i++) {
            answer = answer * arr[i] / gcd(answer, arr[i]);
        }
        
        return answer;
    }
    
    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        
        return gcd(b, a % b);
    }
}