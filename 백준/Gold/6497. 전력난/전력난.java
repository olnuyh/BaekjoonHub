import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Road implements Comparable<Road>{
	int start, end, dist;
	
	public Road(int start, int end, int dist) {
		this.start = start;
		this.end = end;
		this.dist = dist;
	}

	@Override
	public int compareTo(Road o) {
		return this.dist - o.dist;
	}
}

public class Main {
	public static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			if(m == 0 && n == 0)
				break;
			
			Road[] city = new Road[n];
			
			int maxCost = 0;
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int z = Integer.parseInt(st.nextToken());
				
				city[i] = new Road(x, y, z);
				maxCost += z;
			}
			
			Arrays.sort(city);
			
			parents = new int[n];
			
			for(int i = 0; i < n; i++)
				parents[i] = i;
			
			for(int i = 0; i < n; i++) {
				Road nowRoad = city[i];
				
				if(find(nowRoad.start) == find(nowRoad.end)) continue;
				
				union(nowRoad.start, nowRoad.end);
				maxCost -= nowRoad.dist;
			}
			
			sb.append(maxCost + "\n");
		}
		
		System.out.println(sb);
	}
	
	public static int find(int v) {
		if(v == parents[v]) return v;
		return parents[v] = find(parents[v]);
	}

	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
}