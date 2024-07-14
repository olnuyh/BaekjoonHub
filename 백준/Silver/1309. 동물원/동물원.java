import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] D = new int[N][3];
        D[0][0] = 1;
        D[0][1] = 1;
        D[0][2] = 1;

        for (int i = 1; i < N; i++) {
            D[i][0] = (D[i - 1][0] + D[i - 1][1] + D[i - 1][2]) % 9901;
            D[i][1] = (D[i - 1][0] + D[i - 1][2]) % 9901;
            D[i][2] = (D[i - 1][0] + D[i - 1][1]) % 9901;
        }

        System.out.println((D[N - 1][0] + D[N - 1][1] + D[N - 1][2]) % 9901);
    }
}