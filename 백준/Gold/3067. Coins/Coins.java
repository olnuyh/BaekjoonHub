import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());

            int[] coins = new int[N + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }

            int M = Integer.parseInt(br.readLine());

            int[][] D = new int[N + 1][M + 1];
            D[0][0] = 1;

            for (int i = 1; i <= N; i++) {
                for (int j = 0; j <= M; j++) {
                    D[i][j] = D[i - 1][j];

                    if (j - coins[i] >= 0) {
                        D[i][j] += D[i][j -coins[i]];
                    }
                }
            }

            sb.append(D[N][M]).append("\n");
        }

        System.out.println(sb);
    }
}
