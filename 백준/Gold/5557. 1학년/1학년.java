import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        long[][] D = new long[N - 1][21];
        D[0][nums[0]] = 1;

        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j <= 20; j++) {
                if (j - nums[i + 1] >= 0) {
                    D[i + 1][j - nums[i + 1]] += D[i][j];
                }

                if (j + nums[i + 1] <= 20) {
                    D[i + 1][j + nums[i + 1]] += D[i][j];
                }
            }
        }

        System.out.println(D[N - 2][nums[N - 1]]);
    }
}
