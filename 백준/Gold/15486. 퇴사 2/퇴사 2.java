import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] consultings = new int[N + 1][2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            consultings[i][0] = Integer.parseInt(st.nextToken());
            consultings[i][1] = Integer.parseInt(st.nextToken());
        }

        long[] profit = new long[N + 2];

        for (int i = N; i >= 1; i--) {
            if (i + consultings[i][0] > N + 1) {
                profit[i] = profit[i + 1];
                continue;
            }

            profit[i] = Math.max(profit[i + 1], profit[i + consultings[i][0]] + consultings[i][1]);
        }

        System.out.println(profit[1]);
    }
}