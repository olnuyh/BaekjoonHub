import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] price = new int[N];
        int sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            price[i] = Integer.parseInt(st.nextToken());
            sum += price[i];
        }

        int total = Integer.parseInt(br.readLine());

        Arrays.sort(price);

        if (total >= sum) {
            System.out.println(price[N - 1]);
        } else {
            for (int i = 0; i < N; i++) {
                if (price[i] <= total / (N - i)) {
                    total -= price[i];
                } else {
                    System.out.println(total / (N - i));
                    break;
                }
            }
        }
    }
}