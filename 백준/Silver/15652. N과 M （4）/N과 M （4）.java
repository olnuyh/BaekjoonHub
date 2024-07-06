import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] nums;
    public static int N,M;
    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = i + 1;
        }

        makeNums(0, 0, new int[M]);

        System.out.println(sb);
    }

    public static void makeNums(int count, int cur, int[] selected) {
        if (count == M) {
            for (int i = 0; i < M; i++) {
                sb.append(selected[i]).append(" ");
            }

            sb.append("\n");

            return;
        }

        for (int i = cur; i < N; i++) {
            selected[count] = nums[i];
            makeNums(count + 1, i, selected);
        }
    }
}