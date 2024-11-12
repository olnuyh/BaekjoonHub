import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Connect implements Comparable<Connect> {
        int target, time;

        public Connect (int target, int time) {
            this.target = target;
            this.time = time;
        }

        @Override
        public int compareTo(Connect c) {
            return this.time - c.time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            List<Connect>[] computers = new ArrayList[n + 1];

            for (int i = 1; i <= n; i++) {
                computers[i] = new ArrayList<>();
            }

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                computers[b].add(new Connect(a, s));
            }

            int[] D = new int[n + 1];
            Arrays.fill(D, Integer.MAX_VALUE);
            D[c] = 0;

            boolean[] visited = new boolean[n + 1];

            PriorityQueue<Connect> pq = new PriorityQueue<>();
            pq.offer(new Connect(c, 0));

            while (!pq.isEmpty()) {
                Connect cur = pq.poll();

                if (visited[cur.target]) {
                    continue;
                }

                visited[cur.target] = true;

                for (Connect next : computers[cur.target]) {
                    if (D[next.target] > D[cur.target] + next.time) {
                        D[next.target] = D[cur.target] + next.time;
                        pq.offer(new Connect(next.target, D[next.target]));
                    }
                }
            }

            int count = 0;
            int total = 0;

            for (int i = 1; i <= n; i++) {
                if (D[i] != Integer.MAX_VALUE) {
                    count++;
                    total = Math.max(total, D[i]);
                }
            }

            sb.append(count).append(" ").append(total).append("\n");
        }

        System.out.println(sb);
    }
}