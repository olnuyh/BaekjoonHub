import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static ArrayList<int[]>[] graph;
    public static int N;
    public static int[] feed;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new int[]{b, c});
            graph[b].add(new int[]{a, c});
        }

        feed = new int[N + 1];

        for (int i = 2; i <= N; i++) {
            feed[i] = Integer.MAX_VALUE;
        }

        move();

        System.out.println(feed[N]);
    }

    public static void move() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.offer(new int[]{1, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            for (int[] dest : graph[cur[0]]) {
                if (feed[cur[0]] + dest[1] < feed[dest[0]]) {
                    feed[dest[0]] = feed[cur[0]] + dest[1];
                    pq.offer(new int[]{dest[0], feed[dest[0]]});
                }
            }
        }
    }
}