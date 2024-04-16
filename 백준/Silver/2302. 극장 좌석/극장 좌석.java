import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        long[] numOfCases = new long[N + 1];
        numOfCases[0] = 1;
        numOfCases[1] = 1;

        for (int i = 2; i <= N; i++) {
            numOfCases[i] = numOfCases[i - 1] + numOfCases[i - 2];
        }

        boolean[] checkVip = new boolean[41];

        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(br.readLine());
            checkVip[num] = true;
        }

        long answer = 1;
        int count = 0;

        for (int i = 1; i <= N; i++) {
            if (checkVip[i]) {
                answer *= numOfCases[count];
                count = 0;
            }else {
                count++;
            }
        }

        if (count != 0)
            answer *= numOfCases[count];

        System.out.println(answer);
    }
}