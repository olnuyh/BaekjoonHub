import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] D = new int[N + 1][10];
        D[0][0] = 1;

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k <= j; k++) {
                    D[i][j] = (D[i][j] + D[i - 1][k]) % 10007;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < 10; i++) {
            count = (count + D[N][i]) % 10007;
        }

        System.out.println(count);
    }
}