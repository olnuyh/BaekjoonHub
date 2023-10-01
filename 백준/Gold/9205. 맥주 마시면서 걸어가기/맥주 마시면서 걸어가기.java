import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Loc{
	int r, c;
	
	public Loc(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class Main {
	public static int N;
	public static List<Loc> store;
	public static int[] end;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			int[] start = new int[2];
			start[0] = Integer.parseInt(st.nextToken());
			start[1] = Integer.parseInt(st.nextToken());
			
			store = new ArrayList<>();
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				store.add(new Loc(x, y));
			}
			
			st = new StringTokenizer(br.readLine());
			end = new int[2];
			end[0] = Integer.parseInt(st.nextToken());
			end[1] = Integer.parseInt(st.nextToken());
			
			if(bfs(start[0], start[1]))
				sb.append("happy").append("\n");
			else
				sb.append("sad").append("\n");
		}
		
		System.out.println(sb);
	}

	public static boolean bfs(int sr, int sc) {
		Queue<Loc> q = new ArrayDeque<>();
		q.offer(new Loc(sr, sc));
		boolean[] visited = new boolean[N];
		
		while(!q.isEmpty()) {
			Loc cur = q.poll();
			
			if(Math.abs(cur.r - end[0]) + Math.abs(cur.c - end[1]) <= 1000)
				return true;
			
			for(int i = 0; i < N; i++) {
				if(visited[i]) continue;
				
				Loc next = store.get(i);
				
				int dist = Math.abs(cur.r - next.r) + Math.abs(cur.c - next.c);
				
				if(dist <= 1000) {
					q.offer(next);
					visited[i] = true;
				}
			}
		}
		
		return false;
	}
}