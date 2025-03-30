import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] D = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                D[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                D[i][j] += Math.max(D[i - 1][j], D[i][j - 1]);

                max = Math.max(max, D[i][j]);
            }
        }

        System.out.println(max);

    }
}
