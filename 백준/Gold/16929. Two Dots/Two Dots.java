import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static char[][] board;
    public static boolean[][] visited;
    public static int[][] deltas = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        boolean flag = false;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited = new boolean[N][M];

                if (hasCycle(i, j, new int[]{i, j}, board[i][j], 1)) {
                    System.out.println("Yes");
                    flag = true;
                    break;
                }
            }

            if (flag) {
                break;
            }
        }

        if (!flag) {
            System.out.println("No");
        }
    }

    public static boolean hasCycle (int r, int c, int[] start, char alpha, int count) {
        visited[r][c] = true;

        for (int d = 0; d < 4; d++) {
            int nr = r + deltas[d][0];
            int nc = c + deltas[d][1];

            if (isIn(nr, nc) && board[nr][nc] == alpha) {
                if (nr == start[0] && nc == start[1] && count >= 4) {
                    return true;
                }

                if (!visited[nr][nc] && hasCycle(nr, nc, start, alpha, count + 1)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isIn (int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}
