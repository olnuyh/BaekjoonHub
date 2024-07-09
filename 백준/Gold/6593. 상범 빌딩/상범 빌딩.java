import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int L, R, C;
    public static int[][] direction = {{0, 0, 1}, {0, 0, -1}, {0, 1, 0}, {0, -1, 0}, {-1, 0, 0}, {1, 0, 0}};
    public static char[][][] building;
    public static boolean[][][] visited;
    public static int[] end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());

            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0) {
                break;
            }

            building = new char[L][R][C];
            visited = new boolean[L][R][C];

            int[] start = new int[3];
            end = new int[3];

            for (int l = 0; l < L; l++) {
                for (int r = 0; r < R; r++) {
                    building[l][r] = br.readLine().toCharArray();
                    for (int c = 0; c < C; c++) {
                        if (building[l][r][c] == 'S') {
                            start[0] = l;
                            start[1] = r;
                            start[2] = c;
                        } else if (building[l][r][c] == 'E') {
                            end[0] = l;
                            end[1] = r;
                            end[2] = c;

                            building[l][r][c] = '.';
                        }
                    }
                }
                st = new StringTokenizer(br.readLine());
            }

            int time = escape(start);

            if (time == -1) {
                sb.append("Trapped!\n");
            } else {
                sb.append("Escaped in ").append(time).append(" minute(s).\n");
            }
        }

        System.out.println(sb);
    }

    public static int escape (int[] start) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(start);
        visited[start[0]][start[1]][start[2]] = true;

        int time = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();

                if (cur[0] == end[0] && cur[1] == end[1] && cur[2] == end[2]) {
                    return time;
                }

                for (int d = 0; d < 6; d++) {
                    int nl = cur[0] + direction[d][0];
                    int nr = cur[1] + direction[d][1];
                    int nc = cur[2] + direction[d][2];

                    if (isIn(nl, nr, nc) && !visited[nl][nr][nc] && building[nl][nr][nc] == '.') {
                        visited[nl][nr][nc] = true;
                        q.offer(new int[]{nl, nr, nc});
                    }
                }
            }

            time++;
        }

        return -1;
    }

    public static boolean isIn(int l, int r, int c) {
        return l >= 0 && l < L && r >= 0 && r < R && c >= 0 && c < C;
    }
}