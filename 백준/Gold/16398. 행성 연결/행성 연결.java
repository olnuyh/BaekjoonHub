import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Planet implements Comparable<Planet>{
        int pos, price;

        public Planet (int pos, int price) {
            this.pos = pos;
            this.price = price;
        }

        @Override
        public int compareTo(Planet o) {
            return this.price - o.price;
        }
    }

    public static int N;
    public static int[][] planets;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        planets = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                planets[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long minPrice = connect(1);

        System.out.println(minPrice);
    }

    public static long connect(int start) {
        long minPrice = 0;

        PriorityQueue<Planet> pq = new PriorityQueue<>();
        pq.offer(new Planet(start, 0));
        boolean[] visited = new boolean[N + 1];

        while (!pq.isEmpty()) {
            Planet planet = pq.poll();

            if (visited[planet.pos]) {
                continue;
            }

            visited[planet.pos] = true;
            minPrice += planet.price;

            for (int i = 1; i <= N; i++) {
                if (!visited[i] && planets[planet.pos][i] > 0) {
                    pq.offer(new Planet(i, planets[planet.pos][i]));
                }
            }
        }

        return minPrice;
    }
}