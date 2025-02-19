import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int M, N;
    public static int[][] map;
    public static int[][] D;
    public static int[][] deltas = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        D = new int[M][N];

        for (int i = 0; i < M; i++) {
            Arrays.fill(D[i], -1);
        }

        dfs (0, 0);

        System.out.println(D[0][0]);
    }

    public static int dfs (int r, int c) {
        if (r == M - 1 && c == N - 1) {
            return 1;
        }

        if (D[r][c] != -1) {
            return D[r][c];
        }

        D[r][c] = 0;

        for (int d = 0; d < 4; d++) {
            int nr = r + deltas[d][0];
            int nc = c + deltas[d][1];

            if (!isIn(nr, nc)) {
                continue;
            }

            if (map[r][c] > map[nr][nc]) {
                D[r][c] += dfs(nr, nc);
            }
        }

        return D[r][c];
    }

    public static boolean isIn (int r, int c) {
        return r >= 0 && r < M && c >= 0 && c < N;
    }
}