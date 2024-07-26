import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int[][] deltas = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
    public static int N, M;
    public static int[][] farm;
    public static boolean[][] checked;
    public static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        farm = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                farm[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        checked = new boolean[N][M];
        count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (farm[i][j] != 0 && !checked[i][j]) {
                    findSameHeight(new int[]{i, j}, farm[i][j]);
                }
            }
        }

        System.out.println(count);
    }

    public static void findSameHeight(int[] start, int val) {
        ArrayList<int[]> list = new ArrayList<>();
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];

        list.add(start);
        q.offer(start);
        visited[start[0]][start[1]] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int d = 0; d < 8; d++) {
                int nr = cur[0] + deltas[d][0];
                int nc = cur[1] + deltas[d][1];

                if (isIn(nr, nc) && !visited[nr][nc] && farm[nr][nc] == val) {
                    list.add(new int[]{nr, nc});
                    q.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }

        if (isPeak(list, val)) {
            count++;
        }
    }

    public static boolean isPeak(ArrayList<int[]> list, int val) {
        for (int[] pos : list) {
            for (int d = 0; d < 8; d++) {
                int nr = pos[0] + deltas[d][0];
                int nc = pos[1] + deltas[d][1];

                if (!isIn(nr, nc)) {
                    continue;
                }

                if (farm[nr][nc] > val) {
                    return false;
                }
            }
        }

        for (int[] pos : list) {
            checked[pos[0]][pos[1]] = true;
        }

        return true;
    }

    public static boolean isIn(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

}