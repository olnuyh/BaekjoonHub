import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class State {
        int r, c, move, supplies;

        public State (int r, int c, int move, int supplies) {
            this.r = r;
            this.c = c;
            this.move = move;
            this.supplies = supplies;
        }
    }

    public static int N, M;
    public static char[][] map;
    public static int[][] deltas = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[M][N];

        int[] start = new int[2];

        char alpha = 'F';

        for (int i = 0; i < M; i++) {
            map[i] = br.readLine().toCharArray();

            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'S') {
                    start[0] = i;
                    start[1] = j;
                    map[i][j] = '.';
                } else if (map[i][j] == 'X') {
                    map[i][j] = alpha++;
                }
            }
        }

        visited = new boolean[(int)Math.pow(2, alpha - 'F')][M][N];

        int time = move(start[0], start[1], (int)Math.pow(2, alpha - 'F') - 1);

        System.out.println(time);
    }

    public static int move (int sr, int sc, int full) {
        Queue<State> q = new ArrayDeque<>();
        q.offer(new State(sr, sc, 0, 0));

        visited[0][sr][sc] = true;

        while (!q.isEmpty()) {
            State s = q.poll();

            if (map[s.r][s.c] == 'E' && s.supplies == full) {
                return s.move;
            }

            for (int d = 0; d < 4; d++) {
                int nr = s.r + deltas[d][0];
                int nc = s.c + deltas[d][1];

                if (isIn(nr, nc)) {
                    if (map[nr][nc] == '#') {
                        continue;
                    }

                    int supplies = s.supplies;

                    if (map[nr][nc] != '.' && map[nr][nc] != 'E') {
                        supplies |= (1 << (map[nr][nc] - 'F'));
                    }

                    if (!visited[supplies][nr][nc]) {
                        q.offer(new State(nr, nc, s.move + 1, supplies));
                        visited[supplies][nr][nc] = true;
                    }
                }
            }
        }

        return -1;
    }

    public static boolean isIn (int r, int c) {
        return r >= 0 && r < M && c >= 0 && c < N;
    }
}