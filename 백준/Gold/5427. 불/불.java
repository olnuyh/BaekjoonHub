import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos{
	int r, c, time;
	
	public Pos(int r, int c) {
		this.r = r;
		this.c = c;
	}
	
	public Pos(int r, int c, int time) {
		this.r = r;
		this.c = c;
		this.time = time;
	}
}

public class Main {
    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};
    public static Queue<Pos> fire;
    public static Queue<Pos> person;
    public static char[][] map;
    public static int w, h;
    public static int minTime;

public static void escape() {
    while(!person.isEmpty()) {
        //불 옮김
        int size = fire.size();
        
        while(--size >= 0) {
            Pos now = fire.poll();
            
            for(int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];
                
                if(nr < 0 || nr >= h || nc < 0 || nc >= w) continue;
                
                if(map[nr][nc] == '.' || map[nr][nc] == '@') {
                    map[nr][nc] = '*';
                    fire.offer(new Pos(nr, nc));
                }
            }
        }
        
        // 상근이 이동
        size = person.size();
        
        while(--size >= 0) {
        	Pos now = person.poll();
            
            for(int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];
                
                if(nr < 0 || nr >= h || nc < 0 || nc >= w) {
                	minTime = now.time + 1;
                	return;
                }
                
                if(map[nr][nc] == '.') {
                	map[nr][nc] = '@';
                    person.offer(new Pos(nr, nc, now.time + 1));
                }
            }
            
        }
    }
}

public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;
    
    int t = Integer.parseInt(br.readLine());
    
    for(int tc = 1; tc <= t; tc++) {
        st = new StringTokenizer(br.readLine());
        
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        
        map = new char[h][w];
        
        int[] start = new int[2];
        fire = new ArrayDeque();
        person = new ArrayDeque<>();
        
        for(int i = 0; i < h; i++) {
            String str = br.readLine();
            for(int j = 0; j < w; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j] == '@') {
                    start[0] = i;
                    start[1] = j;
                    person.offer(new Pos(i, j, 0));
                }else if(map[i][j] == '*')
                    fire.offer(new Pos(i, j));
            }
        }
        
        minTime = 0;
        
        escape();
        
        if(minTime == 0)
        	sb.append("IMPOSSIBLE\n");
        else
        	sb.append(minTime + "\n");
    }
    
    	System.out.println(sb);
	}
}