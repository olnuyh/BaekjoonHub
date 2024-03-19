import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] move = new int[101];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            move[x] = y;
        }

        for (int j = 0; j < M; j++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            move[u] = -v;
        }

        int[] minCount = new int[101];

        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        minCount[1] = 1;

        while(!q.isEmpty()){
            int now = q.poll();

            for (int i = 1; i <= 6; i++) {
                int next = now + i;

                if(next > 100)
                    break;

                if(move[next] > 0)
                    next = move[next];
                else if(move[next] < 0)
                    next = -move[next];

                if(minCount[next] == 0){
                    minCount[next] = minCount[now] + 1;
                    q.add(next);
                }
            }
        }

        System.out.println(minCount[100] - 1);
    }
}