import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int[] D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        D = new int[N];
        int[] order = new int[N];

        D[0] = A[0];
        int len = 1;

        for (int i = 1; i < N; i++) {
            int pos = findPos(0, len, A[i]);

            if (pos == -1) {
                D[len] = A[i];
                order[i] = len++;
            } else {
                D[pos] = A[i];
                order[i] = pos;
            }
        }

        sb.append(len).append("\n");

        int[] answer = new int[len];

        len -= 1;

        for (int i = N - 1; i >= 0; i--) {
            if (order[i] == len) {
                answer[len--] = A[i];
            }
        }

        for (int i = 0; i < answer.length; i++) {
            sb.append(answer[i]).append(" ");
        }

        System.out.println(sb);
    }

    public static int findPos (int start, int end, int val) {
        int result = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (D[mid] >= val) {
                end = mid - 1;
                result = mid;
            } else {
                start = mid + 1;
            }
        }

        return result;
    }
}