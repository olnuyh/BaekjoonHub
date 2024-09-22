import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        parents = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 1; j <= N; j++) {
                if(Integer.parseInt(st.nextToken()) == 1) {
                    union(i, j);
                }
            }
        }

        int[] route = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            route[i] = Integer.parseInt(st.nextToken());
        }

        boolean isPossible = true;

        for(int i = 0; i < M - 1; i++) {
            int start = route[i];
            int end = route[i + 1];

            if(find(start) != find(end)) {
                isPossible = false;
                break;
            }
        }

        if (isPossible) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static int find(int a) {
        if(a == parents[a]) {
            return a;
        }

        return find(parents[a]);
    }

    public static void union(int a, int b) {
        int pA = find(a);
        int pB = find(b);

        if(pA != pB) {
            parents[pB] = pA;
        }
    }
}