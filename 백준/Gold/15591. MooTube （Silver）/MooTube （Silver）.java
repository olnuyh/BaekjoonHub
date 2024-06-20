import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Video {
        int num, usado;

        public Video(int num, int usado) {
            this.num = num;
            this.usado = usado;
        }

    }

    public static ArrayList<Video>[] mootube;
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        mootube = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            mootube[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            mootube[p].add(new Video(q, r));
            mootube[q].add(new Video(p, r));
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            sb.append(bfs(v, k)).append("\n");
        }

        System.out.println(sb);
    }

    public static int bfs(int start, int k) {
        Queue<Video> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];
        visited[start] = true;
        q.offer(new Video(start, 1000000000));

        int count = 0;

        while (!q.isEmpty()) {
            Video cur = q.poll();

            for (int i = 0; i < mootube[cur.num].size(); i++) {
                Video next = mootube[cur.num].get(i);

                if (!visited[next.num]) {
                    visited[next.num] = true;
                    int minUsado = Integer.min(cur.usado, next.usado);
                    if (minUsado >= k) {
                        count++;
                    }
                    q.offer(new Video(next.num, minUsado));
                }
            }
        }

        return count;
    }
}