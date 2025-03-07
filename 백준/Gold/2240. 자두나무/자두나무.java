import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] plum = new int[T + 1];

        for (int i = 1; i <= T; i++) {
            plum[i] = Integer.parseInt(br.readLine()) - 1;
        }

        int[][][] D = new int[T + 1][2][W + 1];

        for (int i = 0; i <= T; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(D[i][j], -1);
            }
        }

        D[0][0][0] = 0;

        for (int i = 1; i <= T; i++) {
            for (int j = 0; j < 2; j++) {
                int val = plum[i] == j? 1 : 0;

                for (int k = 0; k <= W; k++) {
                    if (D[i - 1][j][k] != -1) {
                        D[i][j][k] = D[i - 1][j][k] + val;
                    }

                    if (k == 0) {
                        continue;
                    }

                    if (D[i - 1][1 - j][k - 1] != -1) {
                        D[i][j][k] = Math.max(D[i][j][k], D[i - 1][1 - j][k - 1] + val);
                    }
                }
            }
        }

        int max = 0;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j <= W; j++) {
                max = Math.max(max, D[T][i][j]);
            }
        }

        System.out.println(max);
    }
}
