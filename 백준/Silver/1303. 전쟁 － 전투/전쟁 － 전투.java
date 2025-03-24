import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static char[][] map;
    public static boolean[][] visited;
    public static int[][] deltas = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[M][N];

        for (int i = 0; i < M; i++) {
            map[i] = br.readLine().toCharArray();
        }

        visited = new boolean[M][N];

        int[] sum = new int[2];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    int result = bfs(i, j, map[i][j]);
                    if(map[i][j] == 'W') {
                        sum[0] += result * result;
                    } else {
                        sum[1] += result * result;
                    }
                }
            }
        }

        System.out.println(sum[0] + " " + sum[1]);
    }

    public static int bfs (int r, int c, char alpha) {
        visited[r][c] = true;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r, c});

        int result = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + deltas[d][0];
                int nc = cur[1] + deltas[d][1];

                if (isIn(nr, nc) && map[nr][nc] == alpha && !visited[nr][nc]) {
                    q.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                    result++;
                }
            }
        }

        return result;
    }

    public static boolean isIn (int r, int c) {
        return r >= 0 && r < M && c >= 0 && c < N;
    }
}
