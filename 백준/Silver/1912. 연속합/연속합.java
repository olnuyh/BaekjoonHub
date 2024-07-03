import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] numbers = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int maxSum = Integer.MIN_VALUE;

        int[] D = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            D[i] = Math.max(D[i - 1] + numbers[i], numbers[i]);
            maxSum = Math.max(maxSum, D[i]);
        }

        System.out.println(maxSum);
    }
}