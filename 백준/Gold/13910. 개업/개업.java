import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] size = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            size[i] = Integer.parseInt(st.nextToken());
        }

        Set<Integer> cooking = new HashSet<>();

        for (int i = 0; i < M; i++) {
            cooking.add(size[i]);

            for (int j = i + 1; j < M; j++) {
                cooking.add(size[i] + size[j]);
            }
        }

        int[] D = new int[N + 1];
        Arrays.fill(D, Integer.MAX_VALUE);

        D[0] = 0;

        for (int count : cooking) {
            if (count <= N) {
                D[count] = 1;
            }
        }

        for (int i = 1; i <= N; i++) {
            if (D[i] == Integer.MAX_VALUE) {
                continue;
            }

            for (int count : cooking) {
                if (i + count <= N) {
                    D[i + count] = Math.min(D[i + count], D[i] + 1);
                }
            }
        }

        if (D[N] == Integer.MAX_VALUE) {
            D[N] = -1;
        }

        System.out.println(D[N]);
    }
}