import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Virus implements Comparable<Virus> {
        int r, c, type;

        public Virus(int r, int c, int type){
            this.r = r;
            this.c = c;
            this.type = type;
        }

        @Override
        public int compareTo(Virus o) {
            if(this.type == o.type){
                if(this.r == o.r)
                    return this.c - o.c;
                return this.r - o.r;
            }
            return this.type - o.type;
        }
    }

    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] tube = new int[N][N];
        PriorityQueue<Virus> pq = new PriorityQueue<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                tube[i][j] = Integer.parseInt(st.nextToken());
                pq.add(new Virus(i, j, tube[i][j]));
            }
        }

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken()) - 1;
        int Y = Integer.parseInt(st.nextToken()) - 1;

        for(int t = 0; t < S; t++){
            Queue<Virus> q = new ArrayDeque<>();
            while(!pq.isEmpty()){
                Virus now = pq.poll();
                for(int d = 0; d < 4; d++){
                    int nr = now.r + dr[d];
                    int nc = now.c + dc[d];

                    if(nr <  0 || nr >= N || nc < 0 || nc >= N)
                        continue;

                    if(tube[nr][nc] == 0){
                        tube[nr][nc] = now.type;
                        q.offer(new Virus(nr, nc, tube[nr][nc]));
                    }
                }
            }

            while(!q.isEmpty())
                pq.add(q.poll());
        }

        System.out.println(tube[X][Y]);
    }
}