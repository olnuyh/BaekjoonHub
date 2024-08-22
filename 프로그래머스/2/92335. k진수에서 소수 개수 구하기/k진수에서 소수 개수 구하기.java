class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String[] str = Long.toString(n, k).split("0");
        
        for (String s : str) {
            if (s.equals("")) {
                continue;
            }
            
            if (isPrime(Long.parseLong(s))) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public boolean isPrime (long n) {
        if (n == 1) {
            return false;
        }
        
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}