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
    public static boolean[][] isOutside;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        int cheezeCount = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) {
                    cheezeCount++;
                }
            }
        }

        int time = 0;

        while (true) {
            if (cheezeCount == 0) {
                break;
            }

            isOutside = new boolean[N][M];

            checkSpace();

            Queue<int[]> meltQ = new ArrayDeque<>();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1 && canMelt(i, j)) {
                        meltQ.offer(new int[]{i, j});
                    }
                }
            }

            cheezeCount -= meltQ.size();

            while (!meltQ.isEmpty()) {
                int[] cur = meltQ.poll();

                map[cur[0]][cur[1]] = 0;
            }

            time++;
        }

        System.out.println(time);
    }

    public static void checkSpace () {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});

        isOutside[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + deltas[d][0];
                int nc = cur[1] + deltas[d][1];

                if (isIn(nr, nc) && !isOutside[nr][nc] && map[nr][nc] == 0) {
                    q.offer(new int[]{nr, nc});
                    isOutside[nr][nc] = true;
                }
            }
        }
    }

    public static boolean canMelt (int r, int c) {
        int cnt = 0;

        for (int d = 0; d < 4; d++) {
            int nr = r + deltas[d][0];
            int nc = c + deltas[d][1];

            if (isIn(nr, nc) && map[nr][nc] == 0 && isOutside[nr][nc]) {
                cnt++;
            }
        }

        if (cnt >= 2) {
            return true;
        }

        return false;
    }

    public static boolean isIn (int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}