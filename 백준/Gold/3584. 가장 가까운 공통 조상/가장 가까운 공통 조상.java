import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static List<Integer>[] tree;
    public static List<Integer> list;
    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        sb = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());

            tree = new List[N + 1];

            for (int i = 1; i <= N; i++) {
                tree[i] = new ArrayList<Integer>();
            }

            StringTokenizer st;
            for (int i = 0; i < N - 1; i++) {
                st = new StringTokenizer(br.readLine());

                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());

                tree[child].add(parent);
            }

            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list = new ArrayList<>();

            dfs(a);
            dfs(b);
        }

        System.out.println(sb);
    }

    public static void dfs (int node) {
        if (list.contains(node)) {
            sb.append(node).append("\n");
            return;
        }

        list.add(node);

        for (int num : tree[node]) {
            dfs(num);
        }
    }
}
