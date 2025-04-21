import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static int[][] arr;
    public static int[][] deltas = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        rotate(R);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void rotate (int R) {
        int cnt = Math.min(N, M) / 2;

        for (int i = 0; i < cnt; i++) {
            int move = R % (((N - i * 2) + (M - i * 2)) * 2 - 4);

            for (int j = 0; j < move; j++) {
                int r = i;
                int c = i;
                int d = 0;

                int temp = arr[r][c];

                while (d < 4) {
                    int nr = r + deltas[d][0];
                    int nc = c + deltas[d][1];

                    if (nr >= i && nr < N - i && nc >= i && nc < M - i) {
                        arr[r][c] = arr[nr][nc];
                        r = nr;
                        c = nc;
                    } else {
                        d++;
                    }
                }

                arr[i + 1][i] = temp;
            }
        }
    }

    public static boolean isIn (int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}
