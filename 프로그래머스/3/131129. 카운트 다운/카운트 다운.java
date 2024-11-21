import java.util.*;

class Solution {
    public int[] solution(int target) {
        
        int[][] D = new int[target + 1][2]; // 숫자 N을 만들기 위해 필요한 최소 다트 수, 최대 싱글/불 수
        
        for (int i = 1; i <= target; i++) {
            D[i][0] = Integer.MAX_VALUE;
        }
        
        int[] scores = new int[62]; // 한 번 던져서 가능한 모든 점수
        
        int idx = 0;
        
        for (int i = 1; i <= 20; i++) {
            scores[idx++] = i; // 싱글
            scores[idx++] = i * 2; // 더블
            scores[idx++] = i * 3; // 트리플
        }
        
        scores[idx] = 50; // 불
        
        for (int i = 1; i <= target; i++) {
            for (int score : scores) {
                if (i >= score) {
                    int dart = D[i - score][0] + 1; // 다트 수는 (i - score)를 만드는 데 사용한 다트 수 + 1
                    int singleOrBull = D[i - score][1];
                    
                    if (score <= 20 || score == 50) { // 싱글이나 불 횟수를 최대화해야 하므로 해당 범위에 있는 경우 싱글이나 불로 생각
                        singleOrBull++;
                    }
                    
                    if (dart < D[i][0]) { // 다트 수 최소 사용 우선
                        D[i][0] = dart;
                        D[i][1] = singleOrBull;
                    } else if (dart == D[i][0] && singleOrBull > D[i][1]) { // 다트 수가 같으면 싱글/불 수 최대화
                        D[i][1] = singleOrBull;
                    }
                }
            }
        }
        
        return D[target];
    }
}