import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static List<Integer>[] tree;
    public static int[] depth, parents;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 1; i <= N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree[a].add(b);
            tree[b].add(a);
        }

        depth = new int[N + 1];
        parents = new int[N + 1];

        visited = new boolean[N + 1];

        dfs(1);

        int M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(findLCA(a, b)).append("\n");
        }

        System.out.println(sb);
    }

    public static void dfs (int node) {
        visited[node] = true;

        for (int next : tree[node]) {
            if (!visited[next]) {
                depth[next] = depth[node] + 1;
                parents[next] = node;
                dfs(next);
            }
        }
    }

    public static int findLCA (int a, int b) {
        if (depth[a] < depth[b]) {
            int temp = b;
            b = a;
            a = temp;
        }

        while (depth[a] != depth[b]) {
            a = parents[a];
        }

        while (a != b) {
            a = parents[a];
            b = parents[b];
        }

        return a;
    }
}
