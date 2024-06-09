import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] wines = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            int amount = Integer.parseInt(br.readLine());

            wines[i] = amount;
        }

        int[] D = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            if (i == 1) {
                D[1] = wines[1];
            } else if (i == 2) {
                D[2] = wines[1] + wines[2];
            } else {
                D[i] = Math.max(Math.max(D[i - 2] + wines[i], D[i - 1]), D[i - 3] + wines[i] + wines[i - 1]);
            }
        }

        System.out.println(D[N]);
    }
}