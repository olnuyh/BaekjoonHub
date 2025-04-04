import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[][] problems = new int[N + 1][2];

        int sum = 0;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            problems[i][0] = Integer.parseInt(st.nextToken());
            problems[i][1] = Integer.parseInt(st.nextToken());

            sum += problems[i][1];
        }

        int[][] D = new int[N + 1][T + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= T; j++) {
                D[i][j] = D[i - 1][j];

                if (j >= problems[i][0]) {
                    D[i][j] = Math.max(D[i][j], D[i - 1][j - problems[i][0]] + problems[i][1]);
                }
            }
        }
        
        System.out.println(sum - D[N][T]);
    }
}
