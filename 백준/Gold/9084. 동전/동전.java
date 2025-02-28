import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());

            int[] coins = new int[N];
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }

            int M = Integer.parseInt(br.readLine());

            int[] D = new int[M + 1];
            D[0] = 1;

            for (int i = 0; i < N; i++) {
                int coin = coins[i];

                for (int j = coin; j <= M; j++) {
                    D[j] += D[j - coin];
                }
            }

            sb.append(D[M]).append("\n");
        }

        System.out.println(sb);
    }
}