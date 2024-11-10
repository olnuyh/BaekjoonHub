import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static int[][] deltas = {{1, -1}, {1, 0}, {1, 1}, {0, -1}, {0, 0}, {0, 1}, {-1, -1}, {-1, 0}, {-1, 1}};
    public static char[][] board;
    public static int R, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        int[] jongsu = new int[2];

        List<int[]> crazy = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();

            for (int j = 0; j < C; j++) {
                if (board[i][j] == 'I') {
                    jongsu[0] = i;
                    jongsu[1] = j;
                } else if (board[i][j] == 'R') {
                    crazy.add(new int[]{i, j});
                }
            }
        }

        char[] tmp = br.readLine().toCharArray();
        int[] command = new int[tmp.length];

        for (int i = 0; i < tmp.length; i++) {
            command[i] = (tmp[i] - '0') - 1;
        }

        boolean finish = false;

        for (int i = 0; i < command.length; i++) {
            // 1. 종수 이동
            int nr = jongsu[0] + deltas[command[i]][0];
            int nc = jongsu[1] + deltas[command[i]][1];

            if (board[nr][nc] == 'R') {
                finish = true;
            }

            board[jongsu[0]][jongsu[1]] = '.';
            board[nr][nc] = 'I';
            jongsu[0] = nr;
            jongsu[1] = nc;

            // 2. 미친 아두이노 이동
            int[][] count = new int[R][C];
            List<int[]> move = new ArrayList();

            for (int[] cur : crazy) {
                int dist = Math.abs(jongsu[0] - cur[0]) + Math.abs(jongsu[1] - cur[1]);
                int[] pos = new int[2];

                for (int d = 0; d < 9; d++) {
                    nr = cur[0] + deltas[d][0];
                    nc = cur[1] + deltas[d][1];

                    if (!isIn(nr, nc)) {
                        continue;
                    }

                    int moveDist = Math.abs(jongsu[0] - nr) + Math.abs(jongsu[1] - nc);

                    if (moveDist < dist) {
                        dist = moveDist;
                        pos[0] = nr;
                        pos[1] = nc;
                    }
                }

                move.add(pos);
                count[pos[0]][pos[1]]++;
            }

            List<int[]> temp = new ArrayList<>();

            for (int j = 0; j < crazy.size(); j++) {
                int[] next = move.get(j);

                if (board[next[0]][next[1]] == 'I') {
                    finish = true;
                    break;
                }

                if (count[next[0]][next[1]] == 1) {
                    temp.add(next);
                }
            }

            if (finish) {
                System.out.println("kraj " + (i + 1));
                break;
            }

            for (int[] cur : crazy) {
                board[cur[0]][cur[1]] = '.';
            }

            for (int[] next : temp) {
                board[next[0]][next[1]] = 'R';
            }

            crazy = temp;
        }

        if (!finish) {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
        }
    }

    public static boolean isIn(int r, int c) {
        return r >= 0 && r < R && c >= 0 && c < C;
    }
}