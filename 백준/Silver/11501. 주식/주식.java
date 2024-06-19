import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            int[] price = new int[N];

            for (int i = 0; i < N; i++) {
                price[i] = Integer.parseInt(st.nextToken());
            }

            long profit = 0;

            Stack<Integer> stack = new Stack<>();

            for (int i = N - 1; i >= 0; i--) {
                if (stack.isEmpty()) {
                    stack.push(price[i]);
                } else if(stack.peek() < price[i]) {
                    stack.pop();
                    stack.push(price[i]);
                } else {
                    profit += stack.peek() - price[i];
                }
            }

            sb.append(profit).append("\n");
        }

        System.out.println(sb);
    }
}