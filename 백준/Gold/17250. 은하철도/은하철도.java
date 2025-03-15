import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] planets;
    public static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        planets = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            planets[i] = Integer.parseInt(br.readLine());
        }

        parents = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int result = union(a, b);

            sb.append(planets[result]).append("\n");
        }

        System.out.println(sb);
    }

    public static int find (int a) {
        if (a == parents[a]) {
            return a;
        }

        return parents[a] = find(parents[a]);
    }

    public static int union (int a, int b) {
        int pA = find(a);
        int pB = find(b);

        if (pA != pB) {
            parents[pB] = pA;
            planets[pA] += planets[pB];
        }

        return parents[pB];
    }
}
