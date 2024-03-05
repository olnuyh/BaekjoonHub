import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static class Schedule{
        int start, end;

        public Schedule(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        ArrayList<Schedule> list = new ArrayList<>();
        int w = 0;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            w = Math.max(w, E);
            list.add(new Schedule(S, E));
        }

        Collections.sort(list, (o1, o2) -> {
            if(o1.start == o2.start){
                return (o2.end - o2.start) - (o1.end - o1.start);
            }
            return o1.start - o2.start;
        });

        int[] checkHeight = new int[w + 2];
        boolean[][] calendar = new boolean[N + 1][w + 1];

        for(Schedule s : list){
            for(int i = 1; i <= N; i++){
                boolean canUse = true;
                for(int j = s.start; j <= s.end; j++){
                    if(calendar[i][j]){
                        canUse = false;
                        break;
                    }
                }

                if(canUse){
                    for(int j = s.start; j <= s.end; j++){
                        calendar[i][j] = true;
                        checkHeight[j] = Math.max(checkHeight[j], i);
                    }
                    break;
                }
            }
        }

        int size = 0;
        int count = 0;
        int maxHeight = 0;
        for(int i = 1; i <= w + 1; i++){
            if(checkHeight[i] == 0){
                size += count * maxHeight;
                count = 0;
                maxHeight = 0;
            }else{
                count++;
                maxHeight = Math.max(maxHeight, checkHeight[i]);
            }
        }

        System.out.println(size);
    }
}