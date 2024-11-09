import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int size = Integer.parseInt(br.readLine());
            pq.offer(size);
        }

        int count = 0;

        while (pq.size() > 1) {
            int next = pq.poll() + pq.poll();
            count += next;
            pq.offer(next);
        }

        System.out.println(count);
    }
}