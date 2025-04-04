import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] money;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        money = new int[N];

        int left = 0;
        int right = 0;

        for (int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(br.readLine());

            left = Math.max(left, money[i]);
            right += money[i];
        }

        int minMoney = right;

        while (left <= right) {
            int mid = (right - left) / 2 + left;

            if (count(mid) <= M) {
                minMoney = mid;

                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(minMoney);
    }

    public static int count (int mid) {
        int count = 1;
        int now = mid;

        for (int i = 0; i < money.length; i++) {
            now -= money[i];

            if (now < 0) {
                count++;
                now = mid - money[i];
            }
        }

        return count;
    }
}
