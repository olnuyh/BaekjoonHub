import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        nums = new int[6];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int min = Integer.MAX_VALUE;
        int max = 0;

        for(int i = 0; i < 6; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        int sum = 0;

        if(N == 1){
            for (int i = 0; i < 6; i++)
                sum += nums[i];

            System.out.println(sum - max);
        }else{
            long answer = 0;

            answer += (long) (getMinPair(1, 5) + Math.min(nums[0], nums[5]))* 4;
            answer += (long) (N - 2) * (N - 1) * 4 * min + (long) (N - 2) * (N - 2) * min;
            answer += (long) getMinPair(0, 6) * 4 * (2 * N - 3);

            System.out.println(answer);
        }
    }

    public static int getMinPair(int start, int end){
        int minPair = Integer.MAX_VALUE;

        for (int i = start; i < end; i++) {
            for(int j = i + 1; j < end; j++){
                if(i + j == 5)
                    continue;

                minPair = Math.min(minPair, nums[i] + nums[j]);
            }
        }

        return minPair;
    }
}