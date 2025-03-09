import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[][] info = new int[N + 1][2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] D = new int[N + 1][T + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= T; j++) {
                D[i][j] = D[i - 1][j];

                if (j - info[i][0] >= 0) {
                    D[i][j] = Math.max(D[i][j], D[i - 1][j - info[i][0]] + info[i][1]);
                }
            }
        }

        System.out.println(D[N][T]);
    }
}
