import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static StringBuilder sb = new StringBuilder();
	public static int N, M;
	public static int[] nums;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			nums[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(nums);
		func(0, new int[M]);
		
		System.out.println(sb);
	}

	public static void func(int cnt, int[] selected) {
		if(cnt == M) {
			for(int i = 0; i < M; i++)
				sb.append(selected[i] + " ");
			sb.append("\n");
			return;
		}
		
		int tmp = -1;
		for(int i = 0; i < N; i++) {
			if(tmp != nums[i]) {
				tmp = nums[i];
				selected[cnt] = nums[i];
				func(cnt + 1, selected);
			}
		}
	}
}