import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int M, N;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[][] deltas = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static boolean canDeliver;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];

        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            char[] temp = br.readLine().toCharArray();

            for (int j = 0; j < N; j++) {
                map[i][j] = temp[j] - '0';
            }
        }

        canDeliver = false;

        for (int j = 0; j < N; j++) {
            if (map[0][j] == 0 && !visited[0][j]) {
                if (dfs(0, j)) {
                    canDeliver = true;
                    break;
                }
            }
        }

        if (canDeliver) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static boolean dfs (int r, int c) {
        if (r == M - 1) {
            return true;
        }

        visited[r][c] = true;

        for (int d = 0; d < 4; d++) {
            int nr = r + deltas[d][0];
            int nc = c + deltas[d][1];

            if (isIn(nr, nc) && map[nr][nc] == 0 && !visited[nr][nc]) {
                if (dfs(nr, nc)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isIn (int r, int c) {
        return r >= 0 && r < M && c >= 0 && c < N;
    }
}
