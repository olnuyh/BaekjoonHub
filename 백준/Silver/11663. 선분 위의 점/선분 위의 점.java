import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int[] points;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        points = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            points[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(points);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            sb.append(binarySearch(left, right)).append("\n");
        }

        System.out.println(sb);
    }

    public static int binarySearch(int left, int right) {
        int result = 0;

        int start = 0;
        int end = N - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (points[mid] > right) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        result = end + 1;

        start = 0;
        end = N - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (points[mid] < left) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        result -= start;

        return result;
    }
}