class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0, sequence.length - 1};
        
        int sum = sequence[0];
        
        int start = 0;
        int end = 1;
        
        while(start < end) {
            if(sum == k) {
                if(end - 1 - start < answer[1] - answer[0]){
                    answer[0] = start;
                    answer[1] = end - 1;
                }
                sum -= sequence[start++];
            }
            else if(sum > k) {
                sum -= sequence[start++];                
            } else if(end < sequence.length) {
                sum += sequence[end++];
            } else{
                break;
            }
        }
        
        return answer;
    }
}