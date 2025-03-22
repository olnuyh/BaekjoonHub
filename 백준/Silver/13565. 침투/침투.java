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
    public static Queue<int[]> q;
    public static boolean canDeliver;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];

        q = new ArrayDeque<>();
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            char[] temp = br.readLine().toCharArray();

            for (int j = 0; j < N; j++) {
                map[i][j] = temp[j] - '0';

                if (i == 0 && map[i][j] == 0) {
                    q.offer(new int[]{0, j});
                    visited[0][j] = true;
                }
            }
        }

        canDeliver = false;
        bfs();

        if (canDeliver) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void bfs () {
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (cur[0] == M - 1) {
                canDeliver = true;
                return;
            }

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
