import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] opposite = {0, 2, 1, 4, 3};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        int N = Integer.parseInt(br.readLine());

        int[][] stores = new int[N + 1][3];

        for (int i = 0; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            stores[i][0] = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            switch (stores[i][0]) {
                case 1:
                    stores[i][1] = 0;
                    stores[i][2] = num;
                    break;
                case 2:
                    stores[i][1] = height;
                    stores[i][2] = num;
                    break;
                case 3:
                    stores[i][1] = num;
                    stores[i][2] = 0;
                    break;
                case 4:
                    stores[i][1] = num;
                    stores[i][2] = width;
                    break;
            }
        }

        int sum = 0;

        for (int i = 0; i < N; i++) {
            int dist = Math.abs(stores[N][1] - stores[i][1]) + Math.abs(stores[N][2] - stores[i][2]);

            if (opposite[stores[N][0]] == stores[i][0]) {
                int dist2 = 2 * (Math.max(stores[N][1], stores[i][1]) + Math.max(stores[N][2], stores[i][2])) - dist;
                sum += Math.min(dist2, 2 * (width + height) - dist2);
            } else {
                sum += Math.min(dist, 2 * (width + height) - dist);
            }
        }

        System.out.println(sum);
    }
}