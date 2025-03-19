import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine());

        String str = Integer.toBinaryString(K + 1);
        char[] arr = str.toCharArray();

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == '0') {
                sb.append(4);
            } else {
                sb.append(7);
            }
        }

        System.out.println(sb);
    }
}
