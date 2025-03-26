import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] visitors = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            visitors[i] = visitors[i - 1] + Integer.parseInt(st.nextToken());
        }

        int max = 0;
        int count = 1;

        for (int i = X; i <= N; i++) {
            int val = visitors[i] - visitors[i - X];

            if (max > val) {
                continue;
            }

            if (max == val) {
                count++;
            } else {
                count = 1;
            }

            max = Math.max(max, val);
        }

        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(count);
        }
    }
}
