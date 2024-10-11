import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int N;
	public static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		
		boolean[] visited = new boolean[N];
		int[] selected = new int[N];

		permutation(0, N, visited, selected);
		
		System.out.println(sb);
	}
	
	public static void permutation (int cur, int k, boolean[] visited, int[] selected) {
		if (cur == k) {
			for (int i = 0; i < k; i++) {
				sb.append(selected[i]).append(" ");
			}
			
			sb.append("\n");
			
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				selected[cur] = i + 1;
				permutation(cur + 1, k, visited, selected);
				visited[i] = false;
			}
		}
	}

}