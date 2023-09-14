import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static boolean[] visited;
	public static int F, G, U, D;
	public static int answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		visited = new boolean[F + 1];
		answer = 0;
		
		if(move(S))
			System.out.println(answer);
		else
			System.out.println("use the stairs");
	}

	public static boolean move(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		visited[start] = true;
		q.add(start);
		
		while(!q.isEmpty()) {
			int size = q.size();
			while(size-- > 0) {
				int cur = q.poll();
				
				if(cur == G) return true;
				
				if(cur + U <= F && !visited[cur + U]) {
					visited[cur + U] = true;
					q.add(cur + U);
				}
				
				if(cur - D >= 1 && !visited[cur - D]) {
					visited[cur - D] = true;
					q.add(cur - D);
				}
			}
			
			answer++;
		}
		
		return false;
	}
}