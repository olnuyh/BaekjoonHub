import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] original = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            original[i] = Integer.parseInt(st.nextToken());
        }

        int[] variation = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            variation[a] += k;
            variation[b] += -k;
        }

        for (int i = 1; i < N; i++) {
            variation[i] += variation[i - 1];
        }

        for (int i = 0; i < N; i++) {
            System.out.print(original[i] + variation[i] + " ");
        }
    }
}