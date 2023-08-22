import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class CCTV{
	int r, c, type;
	
	public CCTV(int r, int c, int type) {
		this.r = r;
		this.c = c;
		this.type = type;
	}
}

public class Main {
	public static int n, m;
	public static int[][] office;
	public static ArrayList<CCTV> list;
	
	public static int minNo;
	
	public static int[] dr = {-1, 1, 0, 0};
	public static int[] dc = {0, 0, -1, 1};
	
	public static int[][] cctv1 = {{0}, {1}, {2}, {3}};
	public static int[][] cctv2 = {{0, 1}, {2, 3}};
	public static int[][] cctv3 = {{0, 3}, {0, 2}, {2, 1}, {3, 1}};
	public static int[][] cctv4 = {{0, 2, 3}, {0, 2, 1}, {1, 2, 3}, {0, 1, 3}};
	public static int[][] cctv5 = {{0, 1, 2, 3}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		office = new int[n][m];
		list = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				office[i][j] = Integer.parseInt(st.nextToken());
				if(office[i][j] != 0 && office[i][j] != 6) 
					list.add(new CCTV(i, j, office[i][j]));
			}
		}
	
		minNo = Integer.MAX_VALUE;
		monitor(0);
		System.out.println(minNo);
	}
	
	public static void monitor(int cnt) {
		if(cnt == list.size()) {
			int no = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(office[i][j] == 0)
						no++;
				}
			}
			
			minNo = Math.min(minNo, no);
			return;
		}
		
		CCTV cctv = list.get(cnt);
		
		switch(cctv.type) {
			case 1:
				for(int i = 0; i < cctv1.length; i++) {
					check(cctv.r, cctv.c, cctv1[i], cnt + 1);
					monitor(cnt + 1);
					revert(cctv.r, cctv.c, cctv1[i], cnt + 1);
				}				
				break;
				
			case 2:
				for(int i = 0; i < cctv2.length; i++) {
					check(cctv.r, cctv.c, cctv2[i], cnt + 1);
					monitor(cnt + 1);
					revert(cctv.r, cctv.c, cctv2[i], cnt + 1);
				}				
				break;
				
			case 3:
				for(int i = 0; i < cctv3.length; i++) {
					check(cctv.r, cctv.c, cctv3[i], cnt + 1);
					monitor(cnt + 1);
					revert(cctv.r, cctv.c, cctv3[i], cnt + 1);
				}				
				break;
				
			case 4:
				for(int i = 0; i < cctv4.length; i++) {
					check(cctv.r, cctv.c, cctv4[i], cnt + 1);
					monitor(cnt + 1);
					revert(cctv.r, cctv.c, cctv4[i], cnt + 1);
				}				
				break;
				
			case 5:
				for(int i = 0; i < cctv5.length; i++) {
					check(cctv.r, cctv.c, cctv5[i], cnt + 1);
					monitor(cnt + 1);
					revert(cctv.r, cctv.c, cctv5[i], cnt + 1);
				}				
				break;
		}
	}
	
	public static void check(int r, int c, int[] dir, int value) {
		for(int i = 0; i < dir.length; i++) {
			int d = dir[i];
			
			for(int l = 1; ; l++) {
				int nr = r + dr[d] * l;
				int nc = c + dc[d] * l;
				
				if(nr < 0 || nr >= n || nc < 0 || nc >= m) break;
				
				if(office[nr][nc] == 6) break;
				
				if(office[nr][nc] == 0)
					office[nr][nc] = -value;
			}
		}
	}
	
	public static void revert(int r, int c, int[] dir, int value) {
		for(int i = 0; i < dir.length; i++) {
			int d = dir[i];
			
			for(int l = 1; ; l++) {
				int nr = r + dr[d] * l;
				int nc = c + dc[d] * l;
				
				if(nr < 0 || nr >= n || nc < 0 || nc >= m) break;
				
				if(office[nr][nc] == 6) break;
				
				if(office[nr][nc] == -value)
					office[nr][nc] = 0;
			}
		}
	}
}