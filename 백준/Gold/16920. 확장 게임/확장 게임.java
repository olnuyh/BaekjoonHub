import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Castle implements Comparable<Castle> {
        int r, c, player;

        public Castle (int r, int c, int player) {
            this.r = r;
            this.c = c;
            this.player = player;
        }

        @Override
        public int compareTo(Castle o) {
            return this.player - o.player;
        }
    }

    public static int N, M;
    public static int[][] deltas = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int[] len = new int[P + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= P; i++) {
            len[i] = Integer.parseInt(st.nextToken());
        }

        int[][] map = new int[N][M];
        int[] answer = new int[P + 1];

        PriorityQueue<Castle> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            char[] arr = br.readLine().toCharArray();

            for (int j = 0; j < M; j++) {
                if (arr[j] == '.') {
                    continue;
                }

                if (arr[j] == '#') {
                    map[i][j] = -1;
                } else {
                    map[i][j] = arr[j] - '0';
                    pq.offer(new Castle(i, j, map[i][j]));
                    answer[map[i][j]]++;
                }
            }
        }

        while (true) {
            if (pq.isEmpty()) {
                break;
            }

            PriorityQueue<Castle> next = new PriorityQueue<>();

            while (!pq.isEmpty()) {
                Queue<Castle> q = new ArrayDeque<>();

                int num = pq.peek().player;

                while (!pq.isEmpty() && pq.peek().player == num) {
                    Castle cur = pq.poll();

                    for (int d = 0; d < 4; d++) {
                        int nr = cur.r + deltas[d][0];
                        int nc = cur.c + deltas[d][1];

                        if (isIn(nr, nc) && map[nr][nc] == 0) {
                            q.offer(new Castle(nr, nc, cur.player));
                            map[nr][nc] = cur.player;
                            answer[cur.player]++;
                        }
                    }
                }

                for (int l = 1; l < len[num]; l++) {
                    if (q.isEmpty()) {
                        break;
                    }

                    int size = q.size();

                    while (--size >= 0) {
                        Castle cur = q.poll();

                        for (int d = 0; d < 4; d++) {
                            int nr = cur.r + deltas[d][0];
                            int nc = cur.c + deltas[d][1];

                            if (isIn(nr, nc) && map[nr][nc] == 0) {
                                q.offer(new Castle(nr, nc, cur.player));
                                map[nr][nc] = cur.player;
                                answer[cur.player]++;
                            }
                        }
                    }
                }

                while (!q.isEmpty()) {
                    next.offer(q.poll());
                }
            }

            pq = next;
        }

        for (int i = 1; i <= P; i++) {
            sb.append(answer[i]).append(" ");
        }

        System.out.println(sb);
    }

    public static boolean isIn (int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}