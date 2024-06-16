import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N, L, R, X;
    public static int[] A;
    public static int count;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        A = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        count = 0;

        chooseProblem(0, 0, 0, new boolean[N]);

        System.out.println(count);
    }

    public static void chooseProblem(int totalNum, int selectedNum, int start, boolean[] selected) {
        if (totalNum == N) {

            if (selectedNum < 2) {
                return;
            }

            int sum = 0;
            int minLevel = Integer.MAX_VALUE;
            int maxLevel = 0;

            for (int i = 0; i < N; i++) {
                if (selected[i]) {
                    sum += A[i];
                    minLevel = Integer.min(minLevel, A[i]);
                    maxLevel = Integer.max(maxLevel, A[i]);
                }
            }

            if (sum >= L && sum <= R && maxLevel - minLevel >= X) {
                count++;
            }

            return;
        }

        for (int i = start; i < N; i++) {
            selected[i] = false;
            chooseProblem(totalNum + 1, selectedNum, i + 1, selected);
            selected[i] = true;
            chooseProblem(totalNum + 1, selectedNum + 1, i + 1, selected);
        }
    }
}