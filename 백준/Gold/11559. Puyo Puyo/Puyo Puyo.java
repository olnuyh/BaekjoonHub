import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Main {
	public static int[][] visited;
	public static int[] dr = {-1, 1, 0, 0};
	public static int[] dc = {0, 0, -1, 1};
	public static char[][] field;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		field = new char[12][6];
		
		for(int r = 0; r < 12; r++) {
			String str = br.readLine();
			for(int c = 0; c < 6; c++)
				field[r][c] = str.charAt(c);
		}
		
		int count = 0;
		
		while(true) {
			visited = new int[12][6];
			List<Integer> list = new ArrayList<>();
			int num = 1;
			for(int r = 0; r < 12; r++) {
				for(int c = 0; c < 6; c++) {
					if(field[r][c] != '.' && visited[r][c] == 0) {
						if(findGroup(r, c, num) >= 4)
							list.add(num);
						num++;
					}
				}
			}
			
			if(list.size() == 0)
				break;
			
			count++;
			
			for(int n : list)
				pop(n);
			
			setting();
		}
		
		System.out.println(count);
	}
	
	public static int findGroup(int sr, int sc, int num) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {sr, sc});
		visited[sr][sc] = num;
		
		int count = 1;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				if(nr < 0 || nr >= 12 || nc < 0 || nc >= 6 || visited[nr][nc] != 0) continue;
				
				if(field[nr][nc] == field[sr][sc]) {
					visited[nr][nc] = num;
					q.offer(new int[] {nr, nc});
					count++;
				}
			}
		}
		
		return count;
	}

	public static void pop(int num) {
		for(int r = 0; r < 12; r++) {
			for(int c = 0; c < 6; c++) {
				if(visited[r][c] == num)
					field[r][c] = '.';
			}
		}
	}
	
	public static void setting() {
		for(int c = 0; c < 6; c++) {
			Stack<Character> stack = new Stack();
			for(int r = 11; r >= 0; r--) {
				if(field[r][c] == '.')
					stack.add('.');
				else {
					while(!stack.isEmpty() && stack.peek() == '.')
						stack.pop();
					stack.add(field[r][c]);
				}
			}
			
			while(stack.size() < 12)
				stack.push('.');
			
			for(int r = 0; r < 12; r++)
				field[r][c] = stack.pop();
		}
	}
}