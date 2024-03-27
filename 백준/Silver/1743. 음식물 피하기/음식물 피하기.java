import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};

    public static int N, M;

    public static int[][] trash;
    public static boolean[][] visited;

    public static Queue<int[]> q;

    public static int bfs(int sr, int sc) {
        int cnt = 1;
        q.offer(new int[]{sr, sc});
        visited[sr][sc] = true;

        while(!q.isEmpty()) {
            int[] now = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = now[0] + dr[d];
                int nc = now[1] + dc[d];

                if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;

                if(!visited[nr][nc] && trash[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    cnt++;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        trash = new int[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;

            trash[r][c] = 1;
        }

        visited = new boolean[N][M];
        q = new ArrayDeque<>();

        int ans = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(trash[i][j] == 1 && !visited[i][j]){
                    ans = Integer.max(ans, bfs(i, j));
                }
            }
        }

        System.out.println(ans);
    }
}