import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Virus {
        int r, c, type;

        public Virus(int r, int c, int type){
            this.r = r;
            this.c = c;
            this.type = type;
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
        ArrayList<Virus> list = new ArrayList<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                tube[i][j] = Integer.parseInt(st.nextToken());
                if(tube[i][j] != 0)
                    list.add(new Virus(i, j, tube[i][j]));
            }
        }

        Collections.sort(list, (o1, o2) -> {
             return o1.type - o2.type;
        });

        Queue<Virus> q = new ArrayDeque<>();
        for(Virus v : list)
            q.offer(v);

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken()) - 1;
        int Y = Integer.parseInt(st.nextToken()) - 1;

        for(int t = 0; t < S; t++){
            list = new ArrayList<>();

            while(!q.isEmpty()){
                Virus now = q.poll();
                for(int d = 0; d < 4; d++){
                    int nr = now.r + dr[d];
                    int nc = now.c + dc[d];

                    if(nr <  0 || nr >= N || nc < 0 || nc >= N)
                        continue;

                    if(tube[nr][nc] == 0){
                        tube[nr][nc] = now.type;
                        list.add(new Virus(nr, nc, tube[nr][nc]));
                    }
                }
            }

            for(Virus v : list)
                q.offer(v);
        }

        System.out.println(tube[X][Y]);
    }
}