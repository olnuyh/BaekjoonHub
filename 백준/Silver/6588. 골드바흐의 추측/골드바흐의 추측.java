import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean[] sosu = new boolean[1000001];

        for (int i = 0; i <= 1000000; i++)
            sosu[i] = true;

        sosu[0] = false;
        sosu[1] = false;

        for (int i = 2; i <= Math.sqrt(1000000); i++) {
            if (sosu[i]) {
                for (int j = i * i; j <= 1000000; j += i)
                        sosu[j] = false;
            }
        }

        while (true) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0)
                break;

            int[] answer = {0, 0};

            for (int i = 3; i <= num / 2; i++) {
                if (sosu[i] && sosu[num - i]) {
                    answer[0] = i;
                    answer[1] = num - i;

                    break;
                }
            }

            if (answer[0] == 0) {
                sb.append("Goldbach's conjecture is wrong.\n");
            } else {
                sb.append(num).append(" = ").append(answer[0]).append(" + ").append(answer[1]).append("\n");
            }
        }

        System.out.println(sb);
    }
}