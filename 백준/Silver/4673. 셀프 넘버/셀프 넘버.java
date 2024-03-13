public class Main {
    public static void main(String[] args) {
        boolean[] noSelfNum = new boolean[10001];

        for(int i = 1; i <= 10000; i++){
            int num = i;
            int newNum = i;

            while(num != 0){
                newNum += num % 10;
                num /= 10;
            }

            if(newNum <= 10000){
                noSelfNum[newNum] = true;
            }
        }

        for(int i = 1; i <= 10000; i++){
            if(!noSelfNum[i])
                System.out.println(i);
        }
    }
}