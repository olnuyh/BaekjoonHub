import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] caffeine = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            caffeine[i] = Integer.parseInt(st.nextToken());
        }

        int[][] D = new int[N + 1][K + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                D[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                D[i][j] = D[i - 1][j];
                if (j - caffeine[i] >= 0 && D[i - 1][j - caffeine[i]] != Integer.MAX_VALUE) {
                    D[i][j] = Math.min(D[i][j], D[i - 1][j - caffeine[i]] + 1);
                }
            }
        }

        if (D[N][K] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(D[N][K]);
        }
    }
}
