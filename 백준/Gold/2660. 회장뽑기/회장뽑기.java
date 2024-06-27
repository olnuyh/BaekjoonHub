import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] group = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            Arrays.fill(group[i], 100);
        }

        for (int i = 1; i <= N; i++) {
            group[i][i] = 0;
        }

        while (true) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1) {
                break;
            }

            group[a][b] = 1;
            group[b][a] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (i == j) {
                        continue;
                    }

                    group[i][j] = Math.min(group[i][j], group[i][k] + group[k][j]);
                }
            }
        }

        int minScore = 100;
        int[] scores = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            int score = 0;
            for (int j = 1; j <= N; j++) {
                score = Math.max(score, group[i][j]);
                scores[i] = score;
            }

            minScore = Math.min(minScore, score);
        }

        ArrayList<Integer> candidates = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if (scores[i] == minScore) {
                candidates.add(i);
            }
        }

        System.out.println(minScore + " " + candidates.size());

        for (int i = 0; i < candidates.size(); i++) {
            System.out.print(candidates.get(i) + " ");
        }
    }
}