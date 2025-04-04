import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Pos implements Comparable<Pos> {
        int r, c, val;

        public Pos (int r, int c, int val) {
            this.r = r;
            this.c = c;
            this.val = val;
        }

        @Override
        public int compareTo(Pos o) {
            return this.val - o.val;
        }
    }

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

        PriorityQueue<Pos> pq = new PriorityQueue<>();
        pq.offer(new Pos(0, 0, 0));

        while (!pq.isEmpty()) {
            Pos cur = pq.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + deltas[d][0];
                int nc = cur.c + deltas[d][1];

                if (nr < 0 || nr > 500 || nc < 0 || nc > 500 || map[nr][nc] < 0) {
                    continue;
                }

                if (D[nr][nc] > D[cur.r][cur.c] + map[nr][nc]) {
                    D[nr][nc] = Math.min(D[nr][nc], D[cur.r][cur.c] + map[nr][nc]);
                    pq.offer(new Pos(nr, nc, D[nr][nc]));
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
