import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] total = new int[N][M];

        total[0][0] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i + 1 < N) {
                    total[i + 1][j] += total[i][j];
                }

                if (j + 1 < M) {
                    total[i][j + 1] += total[i][j];
                }
            }
        }
        if (K == 0) {
            System.out.println(total[N - 1][M - 1]);
        } else {
            int[][] hole = new int[N][M];

            hole[0][0] = 1;
            hole[(K - 1) / M][(K - 1) % M] = -1;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (hole[i][j] == -1) {
                        continue;
                    }

                    if (i + 1 < N && hole[i + 1][j] != -1) {
                        hole[i + 1][j] += hole[i][j];
                    }

                    if (j + 1 < M && hole[i][j + 1] != -1) {
                        hole[i][j + 1] += hole[i][j];
                    }
                }
            }

            System.out.println(total[N - 1][M - 1] - hole[N - 1][M - 1]);
        }
    }
}
