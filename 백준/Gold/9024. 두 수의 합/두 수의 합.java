import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] nums = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(nums);

            int s = 0;
            int e = N - 1;

            int dist = Integer.MAX_VALUE;
            int count = 0;

            while (s < e) {
                int sum = nums[s] + nums[e];

                if (Math.abs(sum - K) < dist) {
                    dist = Math.abs(sum - K);
                    count = 1;
                } else if (Math.abs(sum - K) == dist) {
                    count++;
                }

                if (sum >= K) {
                    e--;
                } else {
                    s++;
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}
