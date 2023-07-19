import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int m, n, h;
	public static int[][] deltas = {{-1, 0, 0}, 
								{1, 0, 0},
								{0, 0, -1},
								{0, 0, 1},
								{0, -1, 0},
								{0, 1, 0}};
	
	public static boolean isIn(int z, int x, int y)
	{
		return z >= 0 && z < h && x >= 0 && x < n && y >= 0 && y < m;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		//Scanner sc = new Scanner(System.in);
		
		m = Integer.parseInt(stk.nextToken());
		n = Integer.parseInt(stk.nextToken());
		h = Integer.parseInt(stk.nextToken());
		
		int[][][] tomatoes = new int[h][n][m];
		
		Queue<int[]> q = new LinkedList<>();
		int isNotRipen = 0;
		
		for(int i = 0; i < h; i++)
		{
			for(int j = 0; j < n; j++)
			{
				stk = new StringTokenizer(br.readLine());
				for(int k = 0; k < m; k++)
				{
					tomatoes[i][j][k] = Integer.parseInt(stk.nextToken());
					if(tomatoes[i][j][k] == 1)
						q.add(new int[] {i, j, k});
					else if(tomatoes[i][j][k] == 0)
						isNotRipen++;
				}
			}
		}
		
		int day = -1;
		int isRipen = 0;
		
		while(!q.isEmpty())
		{
			int size = q.size();
			for(int i = 0; i < size; i++)
			{
				int[] now = q.poll();
				
				for(int j = 0; j < deltas.length; j++)
				{
					int nz = now[0] + deltas[j][0];
					int nx = now[1] + deltas[j][1];
					int ny = now[2] + deltas[j][2];
					
					if(isIn(nz, nx, ny) && tomatoes[nz][nx][ny] == 0)
					{
						tomatoes[nz][nx][ny] = tomatoes[now[0]][now[1]][now[2]] + 1;
						isRipen++;
						q.add(new int[] {nz, nx, ny});
					}				
				}
			}
			
			day++;
		}
		
		if(isRipen == isNotRipen)
			System.out.println(day);
		else
			System.out.println(-1);
	}
}