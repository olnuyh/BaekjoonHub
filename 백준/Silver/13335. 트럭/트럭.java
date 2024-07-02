import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Queue<Integer> bridge = new ArrayDeque<>();

        for (int i = 0; i < w; i++) {
            bridge.offer(0);
        }

        st = new StringTokenizer(br.readLine());

        Queue<Integer> trucks = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            trucks.offer(Integer.parseInt(st.nextToken()));
        }

        int curBridge = 0;
        int time = 0;

        while (!bridge.isEmpty()) {
            curBridge -= bridge.poll();

            if (!trucks.isEmpty()) {
                if (curBridge + trucks.peek() <= L) {
                    curBridge += trucks.peek();
                    bridge.offer(trucks.poll());
                } else {
                    bridge.offer(0);
                }
            }

            time++;
        }

        System.out.println(time);
    }
}