class Solution {
    public int maxDungeon;
    
    public int solution(int k, int[][] dungeons) {
        maxDungeon = 0;
        
        explore(0, k, dungeons, new boolean[dungeons.length], new int[dungeons.length]);
        
        return maxDungeon;
    }
    
    public void explore(int idx, int k, int[][] dungeons, boolean[] visited, int[] selected) {
        if (idx == dungeons.length) {
            int health = k;
            
            int count = 0;
            
            for (int i = 0; i < selected.length; i++) {
                int num = selected[i];
                
                if (health >= dungeons[num][0]) {
                    health -= dungeons[num][1];
                    count++;
                } else {
                    break;
                }
            }
            
            maxDungeon = Math.max(maxDungeon, count);

            return;
        }
        
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected[idx] = i;
                explore(idx + 1, k, dungeons, visited, selected);
                visited[i] = false;
            }
        }
    }
}