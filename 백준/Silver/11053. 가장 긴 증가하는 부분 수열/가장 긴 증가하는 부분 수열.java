import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] D = new int[N];
        int answer = 1;

        for (int i = 0; i < N; i++) {
            D[i] = 1;

            for (int j = 0; j < i; j++) {
                if (A[i] > A[j]) {
                    D[i] = Math.max(D[i], D[j] + 1);
                }
            }

            answer = Math.max(answer, D[i]);
        }

        System.out.println(answer);
    }
}