import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Road implements Comparable<Road> {
        int start, end, cost;

        public Road (int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Road o) {
            return this.cost - o.cost;
        }
    }

    public static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Road> pq = new PriorityQueue<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            pq.offer(new Road(start, end, cost));
        }

        parents = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        int count = 0;
        int minSum = 0;

        while (!pq.isEmpty()) {
            Road cur = pq.poll();

            if (union(cur.start, cur.end)) {
                if (++count != N - 1) {
                    minSum += cur.cost;
                }
            }

            if (count == N - 1) {
                break;
            }
        }

        System.out.println(minSum);
    }

    public static boolean union (int a, int b) {
        int pA = find(a);
        int pB = find(b);

        if (pA == pB) {
            return false;
        }

        parents[pB] = pA;

        return true;
    }

    public static int find (int a) {
        if (parents[a] == a) {
            return a;
        }

        return parents[a] = find(parents[a]);
    }
}
