import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int[] checkHeight = new int[367];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            for (int j = S; j <= E; j++)
                checkHeight[j]++;
        }

        int size = 0;
        int count = 0;
        int maxHeight = 0;
        for(int i = 1; i <= 366; i++){
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