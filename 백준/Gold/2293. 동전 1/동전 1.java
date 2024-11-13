import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coin = new int[N];

        for (int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        int[] D = new int[K + 1];

        D[0] = 1;

        for (int i = 0; i < N; i++) {
            int c = coin[i];

            for (int j = c; j <= K; j++) {
                D[j] += D[j - c];
            }
        }

        System.out.println(D[K]);
    }
}