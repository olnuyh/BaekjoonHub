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

        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] D = new int[N][M];
        D[0][0] = map[0][0];

        for (int i = 1; i < M; i++) {
            D[0][i] = D[0][i - 1] + map[0][i];
        }

        int[] right = new int[M];
        int[] left = new int[M];

        for (int i = 1; i < N; i++) {
            right[0] = D[i - 1][0] + map[i][0];

            for (int j = 1; j < M; j++) {
                right[j] = Math.max(D[i - 1][j], right[j - 1]) + map[i][j];
            }

            left[M - 1] = D[i - 1][M - 1] + map[i][M - 1];

            for (int j = M - 2; j >= 0; j--) {
                left[j] = Math.max(D[i - 1][j], left[j + 1]) + map[i][j];
            }

            for (int j = 0; j < M; j++) {
                D[i][j] = Math.max(right[j], left[j]);
            }
        }

        System.out.println(D[N - 1][M - 1]);
    }
}