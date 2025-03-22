import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int M, N;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[][] deltas = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];

        for (int i = 0; i < M; i++) {
            char[] temp = br.readLine().toCharArray();

            for (int j = 0; j < N; j++) {
                map[i][j] = temp[j] - '0';
            }
        }

        visited = new boolean[M][N];

        for (int j = 0; j < N; j++) {
            if (map[0][j] == 0 && !visited[0][j]) {
                bfs(0, j);
            }
        }

        boolean canDeliver = false;

        for (int j = 0; j < N; j++) {
            if (visited[M - 1][j]) {
                canDeliver = true;
                break;
            }
        }

        if (canDeliver) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void bfs (int r, int c) {
        visited[r][c] = true;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r, c});

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + deltas[d][0];
                int nc = cur[1] + deltas[d][1];

                if (isIn(nr, nc) && map[nr][nc] == 0 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }

    public static boolean isIn (int r, int c) {
        return r >= 0 && r < M && c >= 0 && c < N;
    }
}
