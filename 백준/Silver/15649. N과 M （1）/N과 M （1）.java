import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static boolean[] visited;
    public static int N;
    public static int[] nums;
    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = i + 1;
        }

        visited = new boolean[N];
        sb = new StringBuilder();

        permutation(0, M, new int[M]);

        System.out.println(sb);
    }

    public static void permutation (int depth, int M, int[] selected) {
        if (depth == M) {

            for (int num : selected) {
                sb.append(num).append(" ");
            }

            sb.append("\n");

            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected[depth] = nums[i];
                permutation(depth + 1, M, selected);
                visited[i] = false;
            }
        }
    }
}
