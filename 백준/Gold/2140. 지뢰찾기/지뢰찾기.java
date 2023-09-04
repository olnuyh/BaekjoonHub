import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
	public static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
	public static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	public static int N;
	public static char[][] board;
	public static int[][] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());

		board = new char[N][];
		
		for(int i = 0; i < N; i++) 
			board[i] = br.readLine().toCharArray();
		
		visited = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			if(i == 0 || i == N - 1) {
				for(int j = 0; j < N; j++)
					check(i, j);
			}else {
				check(i, 0);
				check(i, N - 1);
			}
		}
		
		int result = 0;
		for(int i = 1; i < N - 1; i++) {
			for(int j = 1; j < N - 1; j++) {
				if(board[i][j] == '#' && visited[i][j] != -1)
					result++;
			}
		}
		
		System.out.println(result);
	}

	public static void check(int r, int c) {
		int value = board[r][c];
		ArrayList<int []> mazeList = new ArrayList<>();
		int checked = 0;
		for(int i = 0; i < 8; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
			
			if(board[nr][nc] == '#') {
				if(visited[nr][nc] == 0)
					mazeList.add(new int[] {nr, nc});
				else if(visited[nr][nc] == 1)
					checked++;
			}
		}
		
		if(mazeList.size() == board[r][c] - '0' - checked) {
			for(int[] maze : mazeList)
				visited[maze[0]][maze[1]] = 1;
		}else if(mazeList.size() > board[r][c] - '0' - checked) {
			for(int[] maze : mazeList)
				visited[maze[0]][maze[1]] = -1;
		}
	}
}