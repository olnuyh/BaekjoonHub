import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            StringTokenizer st;

            int[][] sticker = new int[2][N + 2];

            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 2; j <= N + 1; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] D = new int[2][N + 2];

            for (int i = 2; i <= N + 1; i++) {
                D[0][i] = Integer.max(D[1][i - 1], Integer.max(D[0][i - 2], D[1][i - 2])) + sticker[0][i];
                D[1][i] = Integer.max(D[0][i - 1], Integer.max(D[0][i - 2], D[1][i - 2])) + sticker[1][i];
            }

            sb.append(Integer.max(D[0][N + 1], D[1][N + 1])).append("\n");
        }

        System.out.println(sb);
    }
}