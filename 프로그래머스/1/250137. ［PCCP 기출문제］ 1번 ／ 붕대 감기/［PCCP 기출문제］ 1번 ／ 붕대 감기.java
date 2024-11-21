class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health;
        int maxTime = attacks[attacks.length - 1][0];
        
        int idx = 0;
        int count = 0;
        
        for (int i = 1; i <= maxTime; i++) {
            if (attacks[idx][0] == i) {
                health -= attacks[idx++][1];
                count = 0;
            } else {
                health = Math.min(health + bandage[1], maxHealth);
                count++;
                
                if (count == bandage[0]) {
                    health = Math.min(health + bandage[2], maxHealth);
                    count = 0;
                }
            }
            
            if (health <= 0) {
                return -1;
            }
        }
        
        return health;
    }
}