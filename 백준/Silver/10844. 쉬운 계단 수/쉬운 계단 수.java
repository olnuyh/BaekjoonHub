import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] D = new int[N + 1][10];

        for (int i = 1; i <= 9; i++) {
            D[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            D[i][0] = D[i - 1][1];

            for (int j = 1; j < 9; j++) {
                D[i][j] = (D[i - 1][j - 1] + D[i - 1][j + 1]) % 1000000000;
            }

            D[i][9] = D[i - 1][8];
        }

        int answer = 0;

        for (int i = 0; i <= 9; i++) {
            answer = (answer + D[N][i]) % 1000000000;
        }

        System.out.println(answer);
    }
}