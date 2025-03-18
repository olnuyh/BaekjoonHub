import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long[][] D = new long[31][31];
        D[0][0] = 1;

        for (int i = 1; i <= 30; i++) {
            D[i][0] = D[i - 1][0];

            for (int j = 1; j <= i; j++) {
                D[i][j] = D[i - 1][j] + D[i][j - 1];
            }
        }

        while (true) {
            int N = Integer.parseInt(br.readLine());

            if (N == 0) {
                break;
            }

            sb.append(D[N][N]).append("\n");
        }

        System.out.println(sb);
    }
}
