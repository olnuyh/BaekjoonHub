import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int[] trees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        trees = new int[N];

        int max = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, trees[i]);
        }

        System.out.println(findMaxHeight(0, max, M));
    }

    public static int findMaxHeight (int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) / 2;

            long sum = 0;

            for (int height : trees) {
                if (height - mid > 0) {
                    sum += height - mid;
                }
            }

            if (sum < target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start - 1;
    }
}