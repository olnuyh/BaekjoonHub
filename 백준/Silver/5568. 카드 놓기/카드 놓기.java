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

        pickNums(0, 0, new int[K]);

        System.out.println(set.size());
    }

    public static void pickNums (int cur, int start, int[] selected) {
        if (cur == K) {
            makeNums(0, new boolean[K], selected, new int[K]);

            return;
        }

        for (int i = start; i < N; i++) {
            selected[cur] = nums[i];
            pickNums(cur + 1, i + 1, selected);
        }
    }

    public static void makeNums (int cur, boolean[] visited, int[] original, int[] selected) {
        if (cur == K) {
            StringBuilder sb = new StringBuilder();

            for (int num : selected) {
                sb.append(num);
            }

            set.add(Integer.parseInt(sb.toString()));
        }

        for (int i = 0; i < original.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected[cur] = original[i];
                makeNums(cur + 1, visited, original, selected);
                visited[i] = false;
            }
        }
    }
}
