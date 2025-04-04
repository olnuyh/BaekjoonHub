import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int[][] deltas = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static final int MAX = 250001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] map = new int[501][501];

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int t = 0; t < N; t++) {
            st = new StringTokenizer(br.readLine());

            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            for (int i = Math.min(r1, r2); i <= Math.max(r1, r2); i++) {
                for (int j = Math.min(c1, c2); j <= Math.max(c1, c2); j++) {
                    map[i][j] = 1;
                }
            }
        }

        int M = Integer.parseInt(br.readLine());

        for (int t = 0; t < M; t++) {
            st = new StringTokenizer(br.readLine());

            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            for (int i = Math.min(r1, r2); i <= Math.max(r1, r2); i++) {
                for (int j = Math.min(c1, c2); j <= Math.max(c1, c2); j++) {
                    map[i][j] = -1;
                }
            }
        }

        int[][] D = new int[501][501];

        for (int i = 0; i <= 500; i++) {
            for (int j = 0; j <= 500; j++) {
                D[i][j] = MAX;
            }
        }

        D[0][0] = 0;

        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{0, 0});

        while (!dq.isEmpty()) {
            int[] cur = dq.poll();

            if (cur[0] == 500 && cur[1] == 500) {
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + deltas[d][0];
                int nc = cur[1] + deltas[d][1];

                if (nr < 0 || nr > 500 || nc < 0 || nc > 500 || map[nr][nc] < 0) {
                    continue;
                }

                if (D[nr][nc] > D[cur[0]][cur[1]] + map[nr][nc]) {
                    D[nr][nc] = Math.min(D[nr][nc], D[cur[0]][cur[1]] + map[nr][nc]);

                    if (map[nr][nc] == 0) {
                        dq.addFirst(new int[]{nr, nc});
                    } else if (map[nr][nc] == 1) {
                        dq.addLast(new int[]{nr, nc});
                    }
                }
            }
        }

        if (D[500][500] == MAX) {
            System.out.println(-1);
        } else {
            System.out.println(D[500][500]);
        }
    }
}
