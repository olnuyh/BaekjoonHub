import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 1; ; t++) {
            int N = Integer.parseInt(br.readLine());

            if (N == 0) {
                break;
            }

            int[][] graph = new int[N][3];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < 3; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            graph[0][0] = Integer.MAX_VALUE;
            graph[0][2] += graph[0][1];

            for (int i = 1; i < N; i++) {
                graph[i][0] += Math.min(graph[i - 1][0], graph[i - 1][1]);
                graph[i][1] += Math.min(Math.min(graph[i - 1][0], graph[i - 1][1]), Math.min(graph[i - 1][2], graph[i][0]));
                graph[i][2] += Math.min(graph[i - 1][2], Math.min(graph[i - 1][1], graph[i][1]));
            }

            sb.append(t).append(". ").append(graph[N - 1][1]).append("\n");
        }

        System.out.println(sb);
    }
}