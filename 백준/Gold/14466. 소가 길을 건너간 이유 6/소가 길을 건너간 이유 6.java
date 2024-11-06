import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int[][] deltas = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static boolean[][][] bridge;
    public static boolean[][] map;
    public static int count;
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        bridge = new boolean[N][N][4];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());

            int r1 = Integer.parseInt(st.nextToken()) - 1;
            int c1 = Integer.parseInt(st.nextToken()) - 1;
            int r2 = Integer.parseInt(st.nextToken()) - 1;
            int c2 = Integer.parseInt(st.nextToken()) - 1;

            if (r1 == r2) { // 가로 길
                int minC = Math.min(c1, c2);
                int maxC = Math.max(c1, c2);

                bridge[r1][minC][1] = true;
                bridge[r2][maxC][3] = true;
            } else { // 세로 길
                int minR = Math.min(r1, r2);
                int maxR = Math.max(r1, r2);

                bridge[minR][c1][2] = true;
                bridge[maxR][c2][0] = true;
            }
        }

        map = new boolean[N][N];
        List<int[]> cows = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;

            map[r][c] = true;
            cows.add(new int[]{r, c});
        }

        count = 0;

        for (int[] cow : cows) {
            move(cow);
        }

        System.out.println((K * (K - 1) - count) / 2);
    }

    public static void move (int[] start) {
        boolean[][] visited = new boolean[N][N];
        visited[start[0]][start[1]] = true;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(start);

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            if (!(cur[0] == start[0] && cur[1] == start[1]) && map[cur[0]][cur[1]]) {
                count++;
            }

            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + deltas[d][0];
                int nc = cur[1] + deltas[d][1];

                if (isIn(nr, nc) && !bridge[cur[0]][cur[1]][d] && !visited[nr][nc]) {
                    q.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }
    }

    public static boolean isIn (int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}