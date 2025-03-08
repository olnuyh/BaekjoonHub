import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[][] deltas = {{-1, -1}, {-1, 0}, {-1, 1}};
    public static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] spaceship = new int[N + 1][M];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                spaceship[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][][] D = new int[N + 1][M][3];

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < 3; k++) {
                    D[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < 3; k++) {
                    for (int t = 0; t < 3; t++) {
                        if (k == t) {
                            continue;
                        }

                        if (isIn(i + deltas[k][0], j + deltas[k][1]) && D[i + deltas[k][0]][j + deltas[k][1]][t] != Integer.MAX_VALUE) {
                            D[i][j][k] = Math.min(D[i][j][k], D[i + deltas[k][0]][j + deltas[k][1]][t] + spaceship[i][j]);
                        }
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;

        for (int j = 0; j < M; j++) {
            for (int k = 0; k < 3; k++) {
                min = Math.min(min, D[N][j][k]);
            }
        }

        System.out.println(min);
    }

    public static boolean isIn (int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}
