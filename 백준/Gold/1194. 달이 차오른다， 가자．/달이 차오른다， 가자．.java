import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Person{
	int r, c, key, move;
	
	public Person() {
		
	}
	
	public Person(int r, int c, int key, int move) {
		this.r = r;
		this.c = c;
		this.key = key;
		this.move = move;
	}
}

public class Main {
	public static int N, M;
	
	public static int[] dr = {-1, 1, 0, 0};
	public static int[] dc = {0, 0, -1, 1};

	public static char[][] maze;
	public static boolean[][][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		maze = new char[N][M];
		visited = new boolean[N][M][64];
		
		Person start = null;
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				maze[i][j] = str.charAt(j);
				if(maze[i][j] == '0') {
					start = new Person(i, j, 0, 0);
					maze[i][j] = '.';
				}
			}
		}
		
		int answer = bfs(start);
		
		System.out.println(answer);
	}

	public static int bfs(Person start) {
		Queue<Person> q = new ArrayDeque<>();
		q.offer(start);
		visited[start.r][start.c][0] = true;
		
		while(!q.isEmpty()) {
			Person now = q.poll();
			int move = now.move;
			
			for(int i = 0; i < 4; i++) {
				int nr = now.r + dr[i];
				int nc = now.c + dc[i];
				int key = now.key;
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc][key] || maze[nr][nc] == '#') continue;
				
				if(maze[nr][nc] == '1') // 출구일 때
					return move + 1;
				
				if("abcdef".indexOf(maze[nr][nc]) >= 0){ // 열쇠가 있는 칸일 때
					key |= (1 << (maze[nr][nc] - 'a')); // 해당 열쇠를 가졌음을 표시
				}else if("ABCDEF".indexOf(maze[nr][nc]) >= 0) { // 문이 있는 칸일 때
					if((key & (1 << (maze[nr][nc] - 'A'))) == 0) // 해당 문을 열 수 있는 열쇠가 없으면
						continue;
				}
				
				visited[nr][nc][key] = true;
				q.offer(new Person(nr, nc, key, move + 1));
			}
		}
		
		return -1;
	}
}