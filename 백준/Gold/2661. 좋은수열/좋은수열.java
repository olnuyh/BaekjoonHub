import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        makeNumber("");
    }

    public static void makeNumber (String str) {
        if (str.length() == N) {
            System.out.println(str);
            System.exit(0);
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (isGood(str + i)) {
                makeNumber(str + i);
            }
        }
    }

    public static boolean isGood (String str) {
        int length = str.length() / 2;

        for (int i = 1; i <= length; i++) {
            String s1 = str.substring(str.length() - i);
            String s2 = str.substring(str.length() - 2 * i, str.length() - i);

            if (s1.equals(s2)) {
                return false;
            }
        }

        return true;
    }
}