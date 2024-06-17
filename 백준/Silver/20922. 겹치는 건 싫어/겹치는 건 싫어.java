import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] count = new int[100001];

        int start = 0;
        int end = 0;

        int maxLength = 0;

        while (end < N) {
            if (count[A[end]] < K) {
                count[A[end]]++;
                end++;
            } else if (count[A[end]] == K){
                count[A[start]]--;
                start++;
            }

            maxLength = Integer.max(maxLength, end - start);
        }

        System.out.println(maxLength);
    }
}