import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int truthNum = Integer.parseInt(st.nextToken());
        int[] truthPeople = new int[truthNum];

        for (int i = 0; i < truthNum; i++) {
            truthPeople[i] = Integer.parseInt(st.nextToken());
        }

        int[][] party = new int[M][];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());

            party[i] = new int[num];

            for (int j = 0; j < num; j++) {
                party[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            int first = party[i][0];

            for (int j = 1; j < party[i].length; j++) {
                union(first, party[i][j]);
            }
        }

        int count = 0;

        for (int i = 0; i < M; i++) {
            int first = party[i][0];

            boolean canLie = true;
            for (int j = 0; j < truthNum; j++) {
                if (find(first) == find(truthPeople[j])) {
                    canLie = false;
                    break;
                }
            }

            if (canLie) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);

        if (parentA != parentB) {
            parent[parentB] = parentA;
        }
    }

    public static int find(int a) {
        if (a == parent[a]) {
            return a;
        }

        return parent[a] = find(parent[a]);
    }
}