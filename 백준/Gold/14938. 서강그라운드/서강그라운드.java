import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int dest, dist;

        public Node (int dest, int dist) {
            this.dest = dest;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }

    public static int[] D;
    public static List<Node>[] graphs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[] items = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        graphs = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graphs[i] = new ArrayList();
        }

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            graphs[a].add(new Node(b, l));
            graphs[b].add(new Node(a, l));
        }

        int maxItem = 0;

        for (int i = 1; i <= N; i++) {
            D = new int[N + 1];
            Arrays.fill(D, Integer.MAX_VALUE);
            D[i] = 0;

            search(i);

            int sum = 0;
            for (int j = 1; j <= N; j++) {
                if (D[j] <= M) {
                    sum += items[j];
                }
            }

            maxItem = Math.max(maxItem, sum);
        }

        System.out.println(maxItem);
    }

    public static void search (int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            for (Node next : graphs[cur.dest]) {
                if (D[next.dest] > D[cur.dest] + next.dist) {
                    D[next.dest] = D[cur.dest] + next.dist;
                    pq.offer(next);
                }
            }
        }
    }
}
