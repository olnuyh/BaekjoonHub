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

        final int NUM = 1000000000;

        int[][] D = new int[K + 1][N + 1];

        for (int i = 0; i <= N; i++) {
            D[1][i] = 1;
        }

        for (int i = 2; i <= K; i++) {
            for (int j = 0; j <= N; j++) {
                for (int k = 0; k <= N; k++) {
                    if (j < k) {
                        continue;
                    }

                    D[i][j] = (D[i][j] + D[i - 1][j - k]) % NUM;
                }
            }
        }

        System.out.println(D[K][N] % NUM);
    }
}