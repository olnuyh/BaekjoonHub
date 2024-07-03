import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] city = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            city[i] = new ArrayList();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            city[A].add(B);
        }

        ArrayList<Integer> answer = new ArrayList<>();

        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];
        q.offer(X);
        visited[X] = true;

        int dist = 1;

        while (!q.isEmpty()) {
            if (dist > K) {
                break;
            }

            int size = q.size();

            while (size-- > 0) {
                int cur = q.poll();

                for (Integer next : city[cur]) {
                    if (!visited[next]) {
                        if (dist == K) {
                            answer.add(next);
                        }

                        q.offer(next);
                        visited[next] = true;
                    }
                }
            }

            dist++;
        }

        Collections.sort(answer);

        if (answer.isEmpty()) {
            sb.append("-1");
        } else {
            for (Integer num : answer) {
                sb.append(num).append("\n");
            }
        }

        System.out.println(sb);
    }
}