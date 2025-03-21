import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] D = new int[K + 1];
        Arrays.fill(D, Integer.MAX_VALUE);
        D[0] = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int caffeine = Integer.parseInt(st.nextToken());

            for (int j = K; j >= 1; j--) {
                if (j - caffeine >= 0 && D[j - caffeine] != Integer.MAX_VALUE) {
                    D[j] = Math.min(D[j], D[j - caffeine] + 1);
                }
            }
        }

        System.out.println(D[K] == Integer.MAX_VALUE ? -1 : D[K]);
    }
}
