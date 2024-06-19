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

        StringTokenizer st = new StringTokenizer(br.readLine());

        int low = 0;
        int high = 0;

        for (int i = 0; i < N; i++) {
            price[i] = Integer.parseInt(st.nextToken());
            high = Integer.max(high, price[i]);
        }
        
        int total = Integer.parseInt(br.readLine());

        int maxBudget = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            int budget = 0;
            for (int money : price) {
                if (money <= mid) {
                    budget += money;
                } else {
                    budget += mid;
                }
            }

            if (budget <= total) {
                maxBudget = Integer.max(maxBudget, mid);
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(maxBudget);
    }
}