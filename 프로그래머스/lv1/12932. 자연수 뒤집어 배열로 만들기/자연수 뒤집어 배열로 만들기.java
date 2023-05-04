class Solution {
    public int[] solution(long n) {
        String str = Long.toString(n);
        String str_reverse = new StringBuilder(str).reverse().toString();
        char[] arr = str_reverse.toCharArray();
        int[] answer = new int[arr.length];
        for(int i = 0; i < arr.length; i++)
            answer[i] = arr[i] - '0';
        return answer;
    }
}