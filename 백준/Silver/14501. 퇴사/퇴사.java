import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] T = new int[N];
        int[] P = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        int[] D = new int[N + 1];

        for (int i = 0; i < N; i++) {
            if (i + T[i] <= N) {
                D[i + T[i]] = Math.max(D[i + T[i]], D[i] + P[i]);
            }

            D[i + 1] = Math.max(D[i + 1], D[i]);
        }
        
        System.out.println(D[N]);
    }
}