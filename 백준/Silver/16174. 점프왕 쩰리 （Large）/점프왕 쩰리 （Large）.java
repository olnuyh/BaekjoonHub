import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[][] dir = {{0, 1}, {1, 0}};
    public static int N;
    public static int[][] map;
    public static boolean[][] visited;
    public static boolean isPossible;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        isPossible = false;
        visited = new boolean[N][N];

        dfs (0, 0);

        if (isPossible) {
            System.out.println("HaruHaru");
        } else {
            System.out.println("Hing");
        }
    }

    public static void dfs (int r, int c) {
        if (r == N - 1 && c == N - 1) {
            isPossible = true;
            return;
        }

        visited[r][c] = true;

        for (int d = 0; d < 2; d++) {
            int nr = r + dir[d][0] * map[r][c];
            int nc = c + dir[d][1] * map[r][c];

            if (isIn(nr, nc) && !visited[nr][nc]) {
                dfs(nr, nc);
            }
        }
    }

    public static boolean isIn (int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}