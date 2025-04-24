import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static char[][] map;
    public static int[][] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        num = new int[N][M];

        int idx = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (num[i][j] == 0) {
                    move(i, j, idx++);
                }
            }
        }

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                set.add(num[i][j]);
            }
        }

        System.out.println(set.size());
    }

    public static int move (int r, int c, int idx) {
        if (num[r][c] != 0) {
            return num[r][c];
        }

        num[r][c] = idx;

        int realIdx = idx;

        if (map[r][c] == 'N') {
            realIdx = move(r - 1, c, idx);
        } else if (map[r][c] == 'E') {
            realIdx = move(r, c + 1, idx);
        } else if (map[r][c] == 'S') {
            realIdx = move(r + 1, c, idx);
        } else {
            realIdx = move(r, c - 1, idx);
        }

        return num[r][c] = realIdx;
    }
}
