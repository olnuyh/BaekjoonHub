import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int[][] T;
    public static int minTime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        T = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                T[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == j || j == k || i == k) {
                        continue;
                    }

                    T[i][j] = Math.min(T[i][j], T[i][k] + T[k][j]);
                }
            }
        }

        minTime = Integer.MAX_VALUE;

        boolean[] visited = new boolean[N];
        int[] order = new int[N];
        order[0] = K;

        makeOrder(1, K, visited, order);

        System.out.println(minTime);
    }

    public static void makeOrder (int depth, int start, boolean[] visited, int[] order) {
        if (depth == N) {
            int time = 0;

            for (int i = 0; i < order.length - 1; i++) {
                time += T[order[i]][order[i + 1]];
            }

            minTime = Math.min(minTime, time);

            return;
        }

        for (int i = 0; i < N; i++) {
            if (i == start) {
                continue;
            }

            if (!visited[i]) {
                visited[i] = true;
                order[depth] = i;
                makeOrder(depth + 1, start, visited, order);
                visited[i] = false;
            }
        }
    }
}