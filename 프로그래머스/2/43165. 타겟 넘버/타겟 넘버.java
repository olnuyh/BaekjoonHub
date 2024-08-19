class Solution {
    public static int answer;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        
        makeTargetNumber(numbers, 0, 0, target);
        
        return answer;
    }
    
    public void makeTargetNumber(int[] numbers, int idx, int sum, int target) {
        if (idx == numbers.length) {
            if (sum == target) {
                answer++;
            }
            
            return;
        }
        
        makeTargetNumber(numbers, idx + 1, sum + numbers[idx], target);
        makeTargetNumber(numbers, idx + 1, sum - numbers[idx], target);
    }
}