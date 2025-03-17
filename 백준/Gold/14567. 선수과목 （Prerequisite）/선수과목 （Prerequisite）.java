import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] graphs = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graphs[i] = new ArrayList();
        }

        int[] in = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graphs[A].add(B);
            in[B]++;
        }

        int[] D = new int[N + 1];

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            if (in[i] == 0) {
                D[i] = 1;
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : graphs[cur]) {
                D[next] = Math.max(D[next], D[cur] + 1);
                in[next]--;

                if (in[next] == 0) {
                    q.offer(next);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(D[i]).append(" ");
        }

        System.out.println(sb);
    }
}
