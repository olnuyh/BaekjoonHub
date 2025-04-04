import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] snacks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        snacks = new int[N];

        st = new StringTokenizer(br.readLine());

        int right = 0;

        for (int i = 0; i < N; i++) {
            snacks[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, snacks[i]);
        }

        int left = 1;

        int max = 0;

        while (left <= right) {
            int mid = (right - left) / 2 + left;

            if (count(mid) >= M) {
                max = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(max);
    }

    public static int count (int mid) {
        int cnt = 0;

        for (int i = 0; i < snacks.length; i++) {
            cnt += snacks[i] / mid;
        }

        return cnt;
    }
}
