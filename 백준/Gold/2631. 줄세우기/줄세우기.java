import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] children = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            children[i] = Integer.parseInt(br.readLine());
        }

        int[] D = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            int max = 0;

            for (int j = 0; j < N; j++) {
                if(children[i] > children[j]) {
                    max = Math.max(max, D[j]);
                }
            }

            D[i] = max + 1;
        }

        int maxChild = 0;

        for (int i = 1; i <= N; i++) {
            maxChild = Math.max(maxChild, D[i]);
        }

        System.out.println(N - maxChild);
    }
}