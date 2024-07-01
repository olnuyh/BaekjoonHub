import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Paper implements Comparable<Paper>{
        int num, score;

        public Paper (int num, int score) {
            this.num = num;
            this.score = score;
        }

        @Override
        public int compareTo(Paper o) {
            if (this.score == o.score) {
                return this.num - o.num;
            }
            return o.score - this.score;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Queue<Paper> q = new ArrayDeque<>();
            PriorityQueue<Paper> pq = new PriorityQueue<>();

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int score = Integer.parseInt(st.nextToken());

                q.offer(new Paper(j, score));
                pq.offer(new Paper(j, score));
            }

            int count = 1;
            while (!q.isEmpty()) {
                if (q.peek().score == pq.peek().score) {
                    pq.poll();

                    Paper paper = q.poll();

                    if (paper.num == M) {
                        sb.append(count).append("\n");
                        break;
                    }
                    count++;
                } else {
                    q.offer(q.poll());
                }
            }
        }

        System.out.println(sb);
    }
}