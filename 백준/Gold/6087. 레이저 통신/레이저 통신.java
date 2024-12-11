import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Pos {
        int dir, r, c;

        public Pos (int dir, int r, int c) {
            this.dir = dir;
            this.r = r;
            this.c = c;
        }
    }

    public static int W, H;
    public static int[][] deltas = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static char[][] map;
    public static int[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new char[H][W];

        List<int[]> temp = new ArrayList<>();

        for (int i = 0; i < H; i++) {
            map[i] = br.readLine().toCharArray();

            for (int j = 0; j < W; j++) {
                if (map[i][j] == 'C') {
                    temp.add(new int[]{i, j});
                }
            }
        }

        int[] start = temp.get(0);
        int[] end = temp.get(1);

        connect(start, end);

        int minMirror = Integer.MAX_VALUE;

        for (int d = 0; d < 4; d++) {
            minMirror = Math.min(minMirror, visited[d][end[0]][end[1]]);
        }

        System.out.println(minMirror);
    }

    public static void connect (int[] start, int[] end) {
        Queue<Pos> q = new ArrayDeque();
        visited = new int[4][H][W];

        for (int d = 0; d < 4; d++) {
            for (int i = 0; i < H; i++) {
                Arrays.fill(visited[d][i], Integer.MAX_VALUE);
            }
        }

        for (int d = 0; d < 4; d++) {
            q.offer(new Pos(d, start[0], start[1]));
            visited[d][start[0]][start[1]] = 0;
        }

        while (!q.isEmpty()) {
            Pos cur = q.poll();

            for (int i = -1; i <= 1; i++) {
                int d = (cur.dir + i + 4) % 4;

                int nr = cur.r + deltas[d][0];
                int nc = cur.c + deltas[d][1];

                if (isIn(nr, nc) && map[nr][nc] != '*') {
                    if (visited[d][nr][nc] > visited[cur.dir][cur.r][cur.c] + Math.abs(i)) {
                        visited[d][nr][nc] = visited[cur.dir][cur.r][cur.c] + Math.abs(i);
                        q.offer(new Pos(d, nr, nc));
                    }
                }
            }
        }
    }

    public static boolean isIn (int r, int c) {
        return r >= 0 && r < H && c >= 0 && c < W;
    }
}