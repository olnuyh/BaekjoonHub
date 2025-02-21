import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int len = 1;
        D = new int[N];
        D[0] = A[0];

        for (int i = 1; i < N; i++) {
            int pos = findPos(0, len, A[i]);

            if (pos == -1) {
                D[len++] = A[i];
            } else {
                D[pos] = A[i];
            }
        }

        System.out.println(len);
    }

    public static int findPos (int start, int end, int val) {
        int result = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (val <= D[mid]) {
                end = mid - 1;
                result = mid;
            } else {
                start = mid + 1;
            }
        }

        return result;
    }
}