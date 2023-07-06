import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Point implements Comparable<Point>{
	int x, y;
	
	Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Point o) {
		if(this.x == o.x)
			return this.y - o.y;
		return this.x - o.x;
	}
	
	
}
class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<Point> list = new ArrayList<>();
		
		for(int i = 0; i < n; i++)
		{
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(stk.nextToken());
			int y = Integer.parseInt(stk.nextToken());
			
			list.add(new Point(x, y));
		}
		
		Collections.sort(list);
		
		for(int i = 0; i < n; i++)
			System.out.println(list.get(i).x + " " + list.get(i).y);
	}
}