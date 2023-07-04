import java.util.*;

class Main{
	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};
	
	public static int n;
	public static int[][] map;
	public static int index = 1;
	
	public static int BFS(int x, int y)
	{
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		map[x][y] = index;
		
		int count = 1;
		
		while(!q.isEmpty())
		{
			int[] now = q.poll();
			for(int i = 0; i < 4; i++)
			{
				int nextX = now[0] + dx[i];
				int nextY = now[1] + dy[i];
				
				if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < n)
				{
					if(map[nextX][nextY] == 1)
					{
						map[nextX][nextY] = index;
						q.add(new int[] {nextX, nextY});
						count++;
					}
				}
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		map = new int[n][n];
		
		for(int i = 0; i < n; i++)
		{
			String s = sc.next();
			for(int j = 0; j < n; j++)
				map[i][j] = s.charAt(j) - '0';
		}
		
		ArrayList<Integer> town = new ArrayList<>();
		
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				if(map[i][j] == 1)
				{
					index++;
					town.add(BFS(i, j));
				}
			}
		}
		
		Collections.sort(town);
		System.out.println(town.size());
		for(int i = 0; i < town.size(); i++)
			System.out.println(town.get(i));
	}
}