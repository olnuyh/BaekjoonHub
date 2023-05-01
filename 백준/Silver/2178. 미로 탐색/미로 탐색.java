import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int [][] A = new int[n][m];
		for(int i = 0; i < n; i++) {
			char[] tmp = sc.next().toCharArray();
			for(int j = 0; j < m; j++)
				A[i][j] = tmp[j] - '0';
		}
		
		boolean[][] visited = new boolean[n][m];
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0, 0));
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			Node now = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int next_r = now.r + dx[i];
				int next_c = now.c + dy[i];
				
				if(next_r >= 0 && next_r < n && next_c >= 0 && next_c < m) {
					if(A[next_r][next_c] == 1 && !visited[next_r][next_c]) {
						visited[next_r][next_c] = true;
						q.add(new Node(next_r, next_c));
						A[next_r][next_c] = A[now.r][now.c] + 1;
					}
				}
			}
		}
		System.out.println(A[n - 1][m - 1]);
	}
}

class Node{
	int r;
	int c;
	
	Node(int r, int c)
	{
		this.r = r;
		this.c = c;
	}
}