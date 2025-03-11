import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        D = new int[N];

        int last = 0;

        for (int i = 0; i < N; i++) {
            int pos = findPos(0, last, nums[i]);

            D[pos] = nums[i];

            if (pos >= last) {
                last++;
            }
        }

        System.out.println(last);
    }

    public static int findPos (int start, int end, int val) {
        while (start < end) {
            int mid = start + (end - start) / 2;

            if (D[mid] < val) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start;
    }
}
