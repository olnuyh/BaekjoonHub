import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static int[] favorites;
    public static StringBuilder sb;
    public static boolean[] visited;
    public static boolean[] done;
    public static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            count = N;

            favorites = new int[N + 1];
            visited = new boolean[N + 1];
            done = new boolean[N + 1];

            st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= N; i++) {
                favorites[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= N; i++) {
                if (!done[i]) {
                    dfs(i);
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }

    public static void dfs (int cur) {
        visited[cur] = true;

        int next = favorites[cur];

        if (!visited[next]) {
            dfs(next);
        }

        if (!done[next]) {
            count--;

            while (next != cur) {
                count--;
                next = favorites[next];
            }
        }

        done[cur] = true;
    }
}