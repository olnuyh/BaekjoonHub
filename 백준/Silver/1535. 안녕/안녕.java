import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] L = new int[N + 1];
        int[] J = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            L[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            J[i] = Integer.parseInt(st.nextToken());
        }

        int[][] D = new int[N + 1][101];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= 100; j++) {
                if (j > L[i]) {
                    D[i][j] = Math.max(D[i - 1][j], J[i] + D[i - 1][j - L[i]]);
                } else {
                    D[i][j] = D[i - 1][j];
                }
            }
        }

        System.out.println(D[N][100]);
    }
}