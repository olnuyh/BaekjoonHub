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

        final int NUM = 1000000000;

        int[][] D = new int[K + 1][N + 1];

        for (int i = 1; i <= K; i++) {
            D[i][0] = 1;
        }

        for (int i = 1; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                D[i][j] = (D[i][j - 1] + D[i - 1][j]) % NUM;
            }
        }

        System.out.println(D[K][N] % NUM);
    }
}