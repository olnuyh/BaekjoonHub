import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] subject = new int[K + 1][2];

        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());

            subject[i][0] = Integer.parseInt(st.nextToken());
            subject[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] D = new int[K + 1][N + 1];

        for (int i = 1; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                D[i][j] = D[i - 1][j];

                if (j - subject[i][1] >= 0) {
                    D[i][j] = Math.max(D[i][j], D[i - 1][j - subject[i][1]] + subject[i][0]);
                }
            }
        }

        System.out.println(D[K][N]);
    }
}
