import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static final int MAX_VALUE = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] D = new int[N + 1][N + 1];

        for(int i = 1; i <= N; i++) {
            Arrays.fill(D[i], MAX_VALUE);
        }

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                int val = Integer.parseInt(st.nextToken());

                if(val == 1) {
                    D[i][j] = 1;
                }
            }
        }

        int[] route = new int[M];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++) {
            route[i] = Integer.parseInt(st.nextToken());
        }

        for(int k = 1; k <= N; k++) {
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    if(i == k || i == j || j == k) {
                        continue;
                    }

                    D[i][j] = Math.min(D[i][j], D[i][k] + D[k][j]);
                }
            }
        }

        boolean isPossible = true;

        for(int i = 0; i < M - 1; i++) {
            int start = route[i];
            int end = route[i + 1];

            if(start == end) {
                continue;
            }

            if(D[start][end] == MAX_VALUE) {
                isPossible = false;
                break;
            }
        }

        if(isPossible) {
            System.out.println("YES");
        } else{
            System.out.println("NO");
        }
    }
}