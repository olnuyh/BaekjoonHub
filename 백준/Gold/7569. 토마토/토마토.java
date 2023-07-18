import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main{
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
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		m = sc.nextInt();
		n = sc.nextInt();
		h = sc.nextInt();
		
		int[][][] tomatoes = new int[h][n][m];
		
		Queue<int[]> q = new LinkedList<>();
		boolean[][][] visited = new boolean[h][n][m];
		
		for(int i = 0; i < h; i++)
		{
			for(int j = 0; j < n; j++)
			{
				for(int k = 0; k < m; k++)
				{
					tomatoes[i][j][k] = sc.nextInt();
					if(tomatoes[i][j][k] == 1)
					{
						q.add(new int[] {i, j, k});
						visited[i][j][k] = true;
					}
				}
			}
		}
		
		int day = -1;
		
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
					
					if(isIn(nz, nx, ny) && !visited[nz][nx][ny] && tomatoes[nz][nx][ny] == 0)
					{
						visited[nz][nx][ny] = true;
						q.add(new int[] {nz, nx, ny});
					}				
				}
			}
			
			day++;
		}
		
		boolean isRipen = true;
		
		outer : for(int i = 0; i < h; i++)
		{
			for(int j = 0; j < n; j++)
			{
				for(int k = 0; k < m; k++)
				{
					if(tomatoes[i][j][k] == 0 && !visited[i][j][k])
					{
						isRipen = false;
						break outer;
					}
				}
			}
		}
		
		if(isRipen)
			System.out.println(day);
		else
			System.out.println(-1);
	}
}