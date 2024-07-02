import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Connection implements Comparable<Connection>{
        int start, end, price;

        public Connection (int start, int end, int price) {
            this.start = start;
            this.end = end;
            this.price = price;
        }

        @Override
        public int compareTo(Connection o) {
            return this.price - o.price;
        }
    }

    public static int N;
    public static PriorityQueue<Connection> network;
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        network = new PriorityQueue<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            network.offer(new Connection(a, b, c));
        }

        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        int minPrice = 0;
        int count = 0;

        while (count < N - 1) {
            Connection connection = network.poll();

            if (union(connection.start, connection.end)) {
                minPrice += connection.price;
                count++;
            }
        }

        System.out.println(minPrice);
    }

    public static boolean union (int a, int b) {
        int parentA = find(a);
        int parentB = find(b);

        if (parentA != parentB) {
            parent[parentA] = parentB;
            return true;
        }

        return false;
    }

    public static int find (int a) {
        if (a == parent[a]) {
            return a;
        }

        return parent[a] = find(parent[a]);
    }
}