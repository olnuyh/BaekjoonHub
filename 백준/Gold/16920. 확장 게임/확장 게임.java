import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
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

        Queue<int[]>[] queues = new Queue[P + 1];

        for (int p = 1; p <= P; p++) {
            queues[p] = new ArrayDeque<>();
        }

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
                    queues[map[i][j]].add(new int[]{i, j});
                    answer[map[i][j]]++;
                }
            }
        }

        while (true) {
            for (int p = 1; p <= P; p++) {
                for (int l = 1; l <= len[p]; l++) {
                    int size = queues[p].size();

                    while (--size >= 0) {
                        int[] cur = queues[p].poll();

                        for (int d = 0; d < 4; d++) {
                            int nr = cur[0] + deltas[d][0];
                            int nc = cur[1] + deltas[d][1];

                            if (isIn(nr, nc) && map[nr][nc] == 0) {
                                map[nr][nc] = p;
                                answer[p]++;
                                queues[p].add(new int[]{nr, nc});
                            }
                        }
                    }

                    if (queues[p].isEmpty()) {
                        break;
                    }
                }
            }

            boolean zero = true;

            for (int p = 1; p <= P; p++) {
                if (!queues[p].isEmpty()) {
                    zero = false;
                    break;
                }
            }

            if (zero) {
                break;
            }
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