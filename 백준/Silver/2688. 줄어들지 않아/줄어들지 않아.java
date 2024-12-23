import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        long[][] D = new long[65][10];

        Arrays.fill(D[0], 1);

        for (int i = 1; i <= 64; i++) {
            D[i][0] = 1;

            for (int j = 1; j < 10; j++) {
                D[i][j] = D[i][j - 1] + D[i - 1][j];
            }
        }

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            sb.append(D[N][9]).append("\n");
        }

        System.out.println(sb);
    }
}