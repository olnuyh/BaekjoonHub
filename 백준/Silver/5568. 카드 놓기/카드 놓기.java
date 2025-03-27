import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static int[] nums;
    public static int N, K;
    public static Set<Integer> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        set = new HashSet<>();

        makeNums(0, new boolean[N], "");

        System.out.println(set.size());
    }

    public static void makeNums (int cur, boolean[] visited, String s) {
        if (cur == K) {
            set.add(Integer.parseInt(s));

            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                makeNums(cur + 1, visited, s + nums[i]);
                visited[i] = false;
            }
        }
    }
}
