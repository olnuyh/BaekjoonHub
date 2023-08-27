import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int n;
	public static int[] people;
	public static ArrayList<Integer>[] city;
	public static int minDiff;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		people = new int[n + 1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++)
			people[i] = Integer.parseInt(st.nextToken());
		
		city = new ArrayList[n + 1];
		
		for(int i = 1; i <= n; i++)
			city[i] = new ArrayList<>();
		
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			
			for(int j = 0; j < cnt; j++) {
				int e = Integer.parseInt(st.nextToken());
				city[i].add(e);
			}
		}
		
		minDiff = Integer.MAX_VALUE;
		subSet(0, new boolean[n]);
		
		if(minDiff == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(minDiff);
	}

	public static void subSet(int cnt, boolean[] choosed) {
		if(cnt == n) {
			boolean[] district = new boolean[n + 1];
			
			int district1 = 0;
			int rep1 = 0;
			int rep2 = 0;
			
			for(int i = 0; i < n; i++) {
				district[i + 1] = choosed[i];
				if(choosed[i]) {
					district1++;
					rep1 = i + 1;
				}
				else 
					rep2 = i + 1;
			}
			
			if(district1 == 0 || district1 == n)
				return;
			
			if(canGo(district, rep1) && canGo(district, rep2)) {
				int sum1 = 0;
				int sum2 = 0;
				
				for(int i = 0; i < choosed.length; i++) {
					if(choosed[i])
						sum1 += people[i + 1];
					else
						sum2 += people[i + 1];
				}
				
				minDiff = Math.min(minDiff, Math.abs(sum1 - sum2));
			}
			
			return;
		}
		
		choosed[cnt] = true;
		subSet(cnt + 1, choosed);
		choosed[cnt] = false;
		subSet(cnt + 1, choosed);
	}
	
	public static boolean canGo(boolean[] district, int start) {
		Queue<Integer> q = new ArrayDeque<>();
		int[] visited = new int[n + 1];
		
		q.add(start);
		visited[start] = 1;
		
		while(!q.isEmpty()) {
			int num = q.poll();

			for(int i = 0; i < city[num].size(); i++) {
				int next = city[num].get(i);
				if(visited[next] == 0 && district[next] == district[start]) {
					q.add(next);
					visited[next] = visited[num] + 1;
				}
			}
		}
		
		for(int i = 1; i <= n; i++) {
			if(district[i] == district[start] && visited[i] == 0)
				return false;
		}
		
		return true;
	}
}