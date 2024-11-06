import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Pipe implements Comparable<Pipe> {
        int start, end, distance;

        public Pipe (int start, int end, int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }

        public int compareTo (Pipe p) {
            return this.distance - p.distance;
        }
    }

    public static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        List<int[]> fields = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            fields.add(new int[]{x, y});
        }

        PriorityQueue<Pipe> pipes = new PriorityQueue<>();

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                int[] a = fields.get(i);
                int[] b = fields.get(j);

                int dist = (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);

                if (dist < C) {
                    continue;
                }

                pipes.offer(new Pipe(i + 1, j + 1, dist));
            }
        }

        parents = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        int minCost = 0;
        int count = N - 1;

        while (!pipes.isEmpty()) {
            Pipe p = pipes.poll();

            if (union(p.start, p.end)) {
                minCost += p.distance;
                count--;
            }

            if (count == 0) {
                break;
            }
        }

        if (count > 0) {
            System.out.println(-1);
        } else {
            System.out.println(minCost);
        }
    }

    public static int find (int a) {
        if (a == parents[a]) {
            return a;
        }

        return parents[a] = find(parents[a]);
    }

    public static boolean union (int a, int b) {
        int pA = find(a);
        int pB = find(b);

        if (pA != pB) {
            parents[pA] = pB;
            return true;
        }

        return false;
    }
}