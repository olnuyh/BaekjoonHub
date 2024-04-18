import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static ArrayList<ArrayList<Integer>> list;
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }


        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        parent = new int[N + 1];

        bfs();

        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]).append("\n");
        }

        System.out.println(sb);
    }

    public static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];
        visited[1] = true;
        q.offer(1);

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int i = 0; i < list.get(now).size(); i++) {
                int next = list.get(now).get(i);

                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                    parent[next] = now;
                }
            }
        }
    }
}