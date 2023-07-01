import java.util.*;

class Pos{
	int x, y;
	
	Pos(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}

public class Main {
	public static int[][] paper;
	public static boolean[][] visited;
	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};
	public static int n, m;
	
	public static int BFS(Pos p)
	{
		Queue<Pos> q = new LinkedList<>();
		q.add(p);
		
		int area = 1;
		visited[p.x][p.y] = true;
		
		while(!q.isEmpty())
		{	
			Pos now = q.poll();
			for(int i = 0; i < 4; i++)
			{
				int nextX = now.x + dx[i];
				int nextY = now.y + dy[i];
				
				if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && !visited[nextX][nextY] && paper[nextX][nextY] == 1)
				{
					visited[nextX][nextY] = true;
					q.add(new Pos(nextX, nextY));
					area++;
				}
			}
		}
		
		return area;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		paper = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < m; j++)
				paper[i][j] = sc.nextInt();
		}
		
		int count = 0;
		int max = 0;
		
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < m; j++)
			{
				if(!visited[i][j] && paper[i][j] == 1)
				{
					max = Math.max(max, BFS(new Pos(i, j)));
					count++;
				}
			}
		}
		
		System.out.println(count);
		System.out.println(max);
	}
}