import java.util.*;

class Solution {
    public static ArrayList<Integer>[] contest;
    public static int[] in;
    public static int[] out;
    public static boolean[] visited;
    
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        contest = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++) {
            contest[i] = new ArrayList<Integer>();
        }
        
        for (int i = 0; i < results.length; i++) {
            int[] result = results[i];
            
            contest[result[0]].add(result[1]);
        }
        
        in = new int[n + 1];
        out = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            dfs(i, i);
        }
        
        for (int i = 1; i <= n; i++) {
            if (in[i] + out[i] == n - 1) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dfs(int start, int cur) {
        for (int i = 0; i < contest[cur].size(); i++) {
            int next = contest[cur].get(i);
            
            if (!visited[next]) {
                visited[next] = true;
                in[next]++;
                out[start]++;
                dfs(start, next);
            }
        }
    }
}