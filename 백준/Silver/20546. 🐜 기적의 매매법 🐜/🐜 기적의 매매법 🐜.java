import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int money = Integer.parseInt(br.readLine());
        int junhyeonMoney = money;
        int sungminMoney = money;

        int[] price = new int[15];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= 14; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        int junhyeonStock = 0;
        int sungminStock = 0;

        for (int i = 1; i <= 14; i++) {
            junhyeonStock += junhyeonMoney / price[i];
            junhyeonMoney = junhyeonMoney % price[i];

            if (i - 3 >= 0) {
                if (price[i - 3] < price[i - 2] && price[i - 2] < price[i - 1]) {
                    sungminMoney += sungminStock * price[i];
                    sungminStock = 0;
                } else if (price[i - 3] > price[i - 2] && price[i - 2] > price[i - 1]) {
                    sungminStock += sungminMoney / price[i];
                    sungminMoney = sungminMoney % price[i];
                }
            }
        }

        if (junhyeonMoney + junhyeonStock * price[14] > sungminMoney + sungminStock * price[14]) {
            System.out.println("BNP");
        } else if (junhyeonMoney + junhyeonStock * price[14] < sungminMoney + sungminStock * price[14]) {
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }
    }
}
