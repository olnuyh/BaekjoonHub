import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] solution = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            solution[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(solution);

        int start = 0;
        int end = N - 1;

        long minDiff = Long.MAX_VALUE;
        int[] answer = new int[2];

        while (start < end) {
            long val = solution[start] + solution[end];

            if (Math.abs(val) < minDiff) {
                minDiff = Math.abs(val);
                answer[0] = solution[start];
                answer[1] = solution[end];
            }

            if (val > 0) {
                end--;
            } else {
                start++;
            }
        }

        System.out.println(answer[0] + " " + answer[1]);
    }
}
