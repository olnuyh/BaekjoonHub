import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;

        for (int i = 1; i < (1 << N); i++) {
            int selected = 0;
            int sum = 0;
            int minLevel = Integer.MAX_VALUE;
            int maxLevel = Integer.MIN_VALUE;

            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) != 0) {
                    selected++;
                    sum += A[j];
                    minLevel = Integer.min(minLevel, A[j]);
                    maxLevel = Integer.max(maxLevel, A[j]);
                }
            }

            if (selected < 2) {
                continue;
            }

            if (sum >= L && sum <= R && maxLevel - minLevel >= X) {
                count++;
            }
        }

        System.out.println(count);
    }
}