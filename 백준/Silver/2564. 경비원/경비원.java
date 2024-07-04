import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        int N = Integer.parseInt(br.readLine());

        int[] stores = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int dir = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            switch (dir) {
                case 1:
                    stores[i] = num;
                    break;
                case 2:
                    stores[i] = width + height + (width - num);
                    break;
                case 3:
                    stores[i] = 2 * (width + height) - num;
                    break;
                case 4:
                    stores[i] = width + num;
                    break;
            }
        }

        int sum = 0;
        int total = 2 * (width + height);

        for (int i = 0; i < N; i++) {
            int dist = Math.abs(stores[i] - stores[N]);
            sum += Math.min(dist, total - dist);
        }

        System.out.println(sum);
    }
}