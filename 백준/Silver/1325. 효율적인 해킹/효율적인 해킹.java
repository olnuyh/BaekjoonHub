import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int maxCnt;
    public static List<Integer>[] computers;
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        computers = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            computers[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            computers[b].add(a);
        }

        maxCnt = 0;

        int[] count = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            count[i] = hacking(i);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            if(count[i] == maxCnt) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
    }

    public static int hacking(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);

        boolean[] visited = new boolean[N + 1];
        visited[start] = true;

        int cnt = 0;

        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int next : computers[cur]) {
                if(!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                    cnt++;
                }
            }
        }

        maxCnt = Math.max(maxCnt, cnt);

        return cnt;
    }
}
