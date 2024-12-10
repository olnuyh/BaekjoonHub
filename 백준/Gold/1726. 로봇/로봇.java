import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Robot {
        int r, c, dir;

        public Robot (int r, int c, int dir) {
            this.r = r;
            this.c = c;
            this.dir = dir;
        }
    }

    public static int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static int M, N;
    public static int[][] factory;
    public static int[][] turn = {{3, 2}, {2, 3}, {0, 1}, {1, 0}};
    public static int[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        factory = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                factory[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int sr = Integer.parseInt(st.nextToken()) - 1;
        int sc = Integer.parseInt(st.nextToken()) - 1;
        int sd = Integer.parseInt(st.nextToken()) - 1;

        Robot start = new Robot(sr, sc, sd);

        st = new StringTokenizer(br.readLine());

        int er = Integer.parseInt(st.nextToken()) - 1;
        int ec = Integer.parseInt(st.nextToken()) - 1;
        int ed = Integer.parseInt(st.nextToken()) - 1;

        Robot end = new Robot(er, ec, ed);

        int result = move(start, end);

        System.out.println(result);
    }

    public static int move (Robot start, Robot end) {
        visited = new int[4][M][N];
        visited[start.dir][start.r][start.c] = 1;

        Queue<Robot> q = new ArrayDeque<>();
        q.offer(new Robot(start.r, start.c, start.dir));

        while (!q.isEmpty()) {
            Robot cur = q.poll();

            if (cur.r == end.r && cur.c == end.c && cur.dir == end.dir) {
                return visited[cur.dir][cur.r][cur.c] - 1;
            }

            // 명령 1
            for (int k = 1; k <= 3; k++) {
                int nr = cur.r + deltas[cur.dir][0] * k;
                int nc = cur.c + deltas[cur.dir][1] * k;

                if (!isIn(nr, nc) || factory[nr][nc] == 1) {
                    break;
                }

                if (visited[cur.dir][nr][nc] == 0) {
                    q.offer(new Robot(nr, nc, cur.dir));
                    visited[cur.dir][nr][nc] = visited[cur.dir][cur.r][cur.c] + 1;
                }
            }

            // 명령 2
            for (int d = 0; d < 2; d++) {
                int dir = turn[cur.dir][d];

                if (visited[dir][cur.r][cur.c] == 0) {
                    q.offer(new Robot(cur.r, cur.c, dir));
                    visited[dir][cur.r][cur.c] = visited[cur.dir][cur.r][cur.c] + 1;
                }
            }
        }

        return 0;
    }

    public static boolean isIn (int r, int c) {
        return r >= 0 && r < M && c >= 0 && c < N;
    }
}