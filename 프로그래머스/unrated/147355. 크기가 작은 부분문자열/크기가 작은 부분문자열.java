class Solution {
    public int solution(String t, String p) {
        int length = p.length();
        int answer = 0;
        for(int i = 0; i <= t.length() - length; i++)
        {
            if(Long.parseLong(p) >= Long.parseLong(t.substring(i, i + length)))
                answer += 1;
        }
        return answer;
    }
}