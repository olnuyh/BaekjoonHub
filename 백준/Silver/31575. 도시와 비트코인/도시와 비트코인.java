import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int[][] city;
    public static int M, N;
    public static int[][] deltas = {{0, 1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        city = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (canGo(0, 0)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static boolean canGo (int sr, int sc) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc});

        boolean[][] visited = new boolean[M][N];
        visited[sr][sc] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (cur[0] == M - 1 && cur[1] == N - 1) {
                return true;
            }

            for (int d = 0; d < 2; d++) {
                int nr = cur[0] + deltas[d][0];
                int nc = cur[1] + deltas[d][1];

                if (isIn(nr, nc) && !visited[nr][nc] && city[nr][nc] == 1) {
                    q.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }


        return false;
    }

    public static boolean isIn (int r, int c) {
        return r >= 0 && r < M && c >= 0 && c < N;
    }
}