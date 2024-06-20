import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int count;
    public static int R, C, K;
    public static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[][] map = new int[R][C];

        for (int i = 0; i < R; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (arr[j] == 'T')
                    map[i][j] = 1;
            }
        }

        count = 0;

        map[R - 1][0] = 1;
        move(map, R - 1, 0, 1);

        System.out.println(count);
    }

    public static void move(int[][] map, int r, int c, int cnt) {
        if (r == 0 && c == C - 1 && cnt == K) {
            count++;
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nr = r + deltas[d][0];
            int nc = c + deltas[d][1];

            if (isIn(nr, nc) && map[nr][nc] == 0) {
                map[nr][nc] = 1;
                move(map, nr, nc, cnt + 1);
                map[nr][nc] = 0;
            }
        }
    }

    public static boolean isIn(int r, int c) {
        return r >= 0 && r < R && c >= 0 && c < C;
    }
}