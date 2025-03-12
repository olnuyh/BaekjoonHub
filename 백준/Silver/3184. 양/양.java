import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int R, C;
    public static char[][] yard;
    public static boolean[][] visited;
    public static int[][] deltas = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static int sheep, wolves;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        yard = new char[R][C];

        sheep = 0;
        wolves = 0;

        for (int i = 0; i < R; i++) {
            yard[i] = br.readLine().toCharArray();

            for (int j = 0; j < C; j++) {
                if (yard[i][j] == 'o') {
                    sheep++;
                } else if (yard[i][j] == 'v') {
                    wolves++;
                }
            }
        }

        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (yard[i][j] == 'o' && !visited[i][j]) {
                    move(i, j);
                }
            }
        }

        System.out.println(sheep + " " + wolves);
    }

    public static void move (int r, int c) {
        int s = 1;
        int w = 0;

        visited[r][c] = true;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r, c});

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + deltas[d][0];
                int nc = cur[1] + deltas[d][1];

                if (isIn(nr, nc) && !visited[nr][nc] && yard[nr][nc] != '#') {
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});

                    if (yard[nr][nc] == 'o') {
                        s++;
                    } else if (yard[nr][nc] == 'v') {
                        w++;
                    }
                }
            }
        }

        if (s > w) {
            wolves -= w;
        } else {
            sheep -= s;
        }
    }

    public static boolean isIn (int r, int c) {
        return r >= 0 && r < R && c >= 0 && c < C;
    }
}
