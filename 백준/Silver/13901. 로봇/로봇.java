import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static int R, C;
    public static int[][] map;
    public static int[] directions;

    public static int sr, sc;
    public static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int k = Integer.parseInt(br.readLine());

        map = new int[R][C];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[r][c] = -1;
        }

        st = new StringTokenizer(br.readLine());

        sr = Integer.parseInt(st.nextToken());
        sc = Integer.parseInt(st.nextToken());

        map[sr][sc] = -1;

        directions = new int[4];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            directions[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        count = 0;

        move(0);

        System.out.println(sr + " " + sc);
    }

    public static void move(int dir) {
        while(true) {
            int nr = sr + deltas[directions[dir]][0];
            int nc = sc + deltas[directions[dir]][1];

            if (isIn(nr, nc) && map[nr][nc] != -1) {
                map[nr][nc] = -1;
                sr = nr;
                sc = nc;
                count = 0;
            } else {
                dir = (dir + 1) % 4;
                count++;
            }

            if(count == 4) {
                break;
            }
        }
    }

    public static boolean isIn(int r, int c) {
        return r >= 0 && r < R && c >= 0 && c < C;
    }
}