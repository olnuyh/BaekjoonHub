import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int[] temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int[] power = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            power[i] = Integer.parseInt(st.nextToken());
        }

        int last = 0;
        temp = new int[N];

        for (int i = 0; i < N; i++) {
            int pos = findPos(0, last, power[i]);
            temp[pos] = power[i];

            if (last <= pos) {
                last++;
            }
        }

        System.out.println(N - last);
    }

    public static int findPos (int start, int end, int val) {
        while (start < end) {
            int mid = start + (end - start) / 2;

            if (temp[mid] > val) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start;
    }
}