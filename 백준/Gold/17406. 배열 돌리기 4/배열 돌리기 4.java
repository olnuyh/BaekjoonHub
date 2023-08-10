import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Operation{
    int r, c, s;

    public Operation(int r, int c, int s) {
        this.r = r;
        this.c = c;
        this.s = s;
    }
}

public class Main {
	public static int n, m;
    public static int[] dr = {1, 0, -1, 0};
    public static int[] dc = {0, 1, 0, -1};
    public static int[][] arr;
    public static int[][] newArr;
    public static ArrayList<Operation> list;
    public static int[] np;
    
	public static void rotation(int r, int c, int s) {       		
        int startR = r - s;
        int startC = c - s;
        int endR = r + s;
        int endC = c + s;
        
        while(startR < endR && startC < endC) {
        	int i = startR;
        	int j = startC;
        	int d = 0;
        	
        	int first = newArr[i][j];
        	
        	while(d != 4) {
        		int nr = i + dr[d];
        		int nc = j + dc[d];
        		
        		if(nr == startR && nc == startC) {
        			newArr[i][j] = first;
        			break;
        		}
        		
        		if(nr < startR || nr > endR || nc < startC || nc > endC) {
        			d++;
        			continue;
        		}
        		
        		newArr[i][j] = newArr[nr][nc];
        		
        		i = nr;
        		j = nc;
        	}
        	
        	startR++;
        	startC++;
        	endR--;
        	endC--;
        }
    }
	
	public static boolean nextPermutation() {
		int peak = np.length - 1;
		
		while(peak > 0 && np[peak - 1] >= np[peak]) peak--;
		
		if(peak == 0) return false;
		
		int change = np.length - 1;
		
		while(np[peak - 1] >= np[change]) change--;
		
		swap(peak - 1, change);
		
		int last = np.length - 1;
		
		while(peak < last) swap(peak++, last--);
		
		return true;
	}
	
	public static void swap(int a, int b) {
		int temp = np[a];
		np[a] = np[b];
		np[b] = temp;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		list = new ArrayList<>();
	    
	    for(int i = 0; i < k; i++) {
	        st = new StringTokenizer(br.readLine());
	        
	        int r = Integer.parseInt(st.nextToken()) - 1;
	        int c = Integer.parseInt(st.nextToken()) - 1;
	        int s = Integer.parseInt(st.nextToken());
	        
	        list.add(new Operation(r, c, s));
	    }
	    
	    np = new int[k];
	    for(int i = 0; i < k; i++)
	    	np[i] = i;
	    
	    int answer = Integer.MAX_VALUE;
	    
	    do {
			newArr = new int[n][m];
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++)
					newArr[i][j] = arr[i][j];
			}
			
			for(int i = 0; i < np.length; i++) {
				Operation op = list.get(np[i]);
				rotation(op.r, op.c, op.s);
			}
			
			int minSum = Integer.MAX_VALUE;
			
			for(int i = 0; i < n; i++) {
				int sum = 0;
				for(int j = 0; j < m; j++)
					sum += newArr[i][j];
				minSum = Math.min(minSum, sum);
			}
			
			answer = Math.min(answer, minSum);
			
		} while (nextPermutation());
	    
	    System.out.println(answer);
	}

}