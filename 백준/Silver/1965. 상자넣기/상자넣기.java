import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] boxes = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            boxes[i] = Integer.parseInt(st.nextToken());
        }

        int[] D = new int[N];
        D[0] = 1;
        int answer = 1;

        for (int i = 1; i < N; i++) {
            D[i] = 1;

            for (int j = i - 1; j >= 0; j--) {
                if (boxes[j] < boxes[i]) {
                    D[i] = Math.max(D[i], D[j] + 1);
                }
            }

            answer = Math.max(answer, D[i]);
        }

        System.out.println(answer);
    }
}