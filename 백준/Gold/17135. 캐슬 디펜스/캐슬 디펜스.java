import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Pos{
	int r, c;
	public Pos(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class Main {
	public static int n, m, d;
	public static ArrayList<Pos> enemies;
	public static int maxAttack;
	public static int[][] map;
	
	public static void setArchers(int cnt, int start, int[] choosed) {
		if(cnt == 3) {
			int attack = 0;
			int[][] newMap = new int[n][m];
			for(int i = n - 1; i >= 0; i--) {
				for(int j = 0; j < m; j++) {
					newMap[i][j] = map[i][j];
					if(newMap[i][j] == 1)
						enemies.add(new Pos(i, j));
				}
			}
			
			while(!enemies.isEmpty()) {
				ArrayList<int[]> removeList = new ArrayList<>();
				
				for(int i = 0; i < 3; i++) {
					int minDist = Integer.MAX_VALUE;
					int[] remove = new int[2];
					for(Pos e : enemies) {
						int dist = Math.abs(n - e.r) + Math.abs(choosed[i] - e.c);
						if(dist > d) continue;
						if(minDist > dist) {
							minDist = dist;
							remove[0] = e.r;
							remove[1] = e.c;
						}else if(minDist == dist) {
							if(remove[1] > e.c) {
								remove[0] = e.r;
								remove[1] = e.c;
							}
						}
					}
					
					if(minDist != Integer.MAX_VALUE)
						removeList.add(new int[] {remove[0], remove[1]});
				}
						
				for(int i = 0; i < removeList.size(); i++) {
					int[] remove = removeList.get(i);
					if(newMap[remove[0]][remove[1]] == 1) {
						newMap[remove[0]][remove[1]] = 0;
						attack++;
					}
				}
				
				enemies.clear();
				
				for(int i = n - 1; i >= 0; i--) {
					for(int j = 0; j < m; j++) {
						if(newMap[i][j] == 1) {
							newMap[i][j] = 0;
							if(i + 1 < n) {
								enemies.add(new Pos(i + 1, j));
								newMap[i + 1][j] = 1;
							}
						}
					}
				}
			}
			
			maxAttack = Math.max(maxAttack, attack);
			return;
		}
		
		for(int i = start; i < m; i++) {
			choosed[cnt] = i;
			setArchers(cnt + 1, i + 1, choosed);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		
		enemies = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		maxAttack = 0;
		
		setArchers(0, 0, new int[3]);
		System.out.println(maxAttack);
	}

}