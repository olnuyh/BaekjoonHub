import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Truck {
        int weight, pos;

        public Truck (int weight, int pos) {
            this.weight = weight;
            this.pos = pos;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Truck> q = new ArrayDeque<>();

        int bridge = 0;
        int idx = 0;
        int time = 1;

        while (true) {
            if (idx == n && q.isEmpty()) {
                break;
            }

            while (!q.isEmpty() && q.peek().pos == w) {
                Truck truck = q.poll();
                bridge -= truck.weight;
            }

            for (Truck truck : q) {
                truck.pos++;
            }

            if (idx < n && bridge + arr[idx] <= L) {
                bridge += arr[idx];
                q.offer(new Truck(arr[idx], 1));
                idx++;
            }

            time++;
        }

        System.out.println(time - 1);
    }
}