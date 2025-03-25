import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int[][] forest;
    public static int[][] deltas = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static int[][] D;
    public static int maxCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        forest = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                forest[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        D = new int[N][N];

        maxCount = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                maxCount = Math.max(maxCount, move(i, j));
            }
        }

        System.out.println(maxCount);
    }

    public static int move (int r, int c) {
        if (D[r][c] != 0) {
            return D[r][c];
        }

        D[r][c] = 1;

        for (int d = 0; d < 4; d++) {
            int nr = r + deltas[d][0];
            int nc = c + deltas[d][1];

            if (isIn(nr, nc) && forest[r][c] < forest[nr][nc]) {
                D[r][c] = Math.max(D[r][c], move(nr, nc) + 1);
            }
        }

        return D[r][c];
    }

    public static boolean isIn (int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}
