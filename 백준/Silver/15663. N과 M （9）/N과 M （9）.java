import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int n, m;
	public static int[] arr;
	public static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		
		permutation(0, new int[m], new boolean[n]);
		
		System.out.println(sb);
	}

	public static void permutation(int cnt, int[] choosed, boolean[] visited) {
		if(cnt == m) {
			for(int i = 0; i < m; i++)
				sb.append(choosed[i] + " ");
			sb.append("\n");
			return;
		}
		
		int prev = 0;
		
		for(int i = 0; i < n; i++) {
			if(!visited[i] && prev != arr[i]) {
				visited[i] = true;
				prev = arr[i];
				choosed[cnt] = arr[i];
				permutation(cnt + 1, choosed, visited);
				visited[i] = false;
			}
		}
	}
}