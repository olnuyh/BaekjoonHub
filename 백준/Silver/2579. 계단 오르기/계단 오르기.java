import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] scores = new int[N + 2];

        for (int i = 2; i <= N + 1; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        int[][] D = new int[N + 2][3];

        for (int i = 2; i <= N + 1; i++) {
            D[i][1] = Math.max(D[i - 2][1], D[i - 2][2]) + scores[i];
            D[i][2] = D[i - 1][1] + scores[i];
        }

        System.out.println(Math.max(D[N + 1][1], D[N + 1][2]));
    }
}