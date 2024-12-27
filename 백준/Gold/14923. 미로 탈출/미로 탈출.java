import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static int[][] map;
    public static int[][] deltas = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] start = new int[2];
        st = new StringTokenizer(br.readLine());

        start[0] = Integer.parseInt(st.nextToken()) - 1;
        start[1] = Integer.parseInt(st.nextToken()) - 1;

        int[] end = new int[2];
        st = new StringTokenizer(br.readLine());

        end[0] = Integer.parseInt(st.nextToken()) - 1;
        end[1] = Integer.parseInt(st.nextToken()) - 1;

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int turn = move(start, end);

        System.out.println(turn);
    }

    public static int move (int[] start, int[] end) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{start[0], start[1], 0});

        int[][][] visited = new int[2][N][M];
        visited[0][start[0]][start[1]] = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (cur[0] == end[0] && cur[1] == end[1]) {
                return visited[cur[2]][cur[0]][cur[1]] - 1;
            }

            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + deltas[d][0];
                int nc = cur[1] + deltas[d][1];

                if (!isIn(nr, nc)) {
                    continue;
                }

                if (map[nr][nc] == 0 && visited[cur[2]][nr][nc] == 0) {
                    visited[cur[2]][nr][nc] = visited[cur[2]][cur[0]][cur[1]] + 1;
                    q.offer(new int[]{nr, nc, cur[2]});
                }

                if (map[nr][nc] == 1 && cur[2] == 0 && visited[1][nr][nc] == 0) {
                    visited[1][nr][nc] = visited[cur[2]][cur[0]][cur[1]] + 1;
                    q.offer(new int[]{nr, nc, 1});
                }
            }
        }

        return -1;
    }

    public static boolean isIn (int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}