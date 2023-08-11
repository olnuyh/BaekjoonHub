/**
@author 김이현
@since 2023. 8. 11.
@see https://www.acmicpc.net/problem/17406
@git
@youtube
@performance 27256KB / 264ms
@category #구현 #순열
@note 
1. 회전 연산 순열 구하기
2. 회전 연산 수행
3. 바뀐 배열을 행마다 돌면서 최솟값을 찾고 배열 A의 값의 최솟값 구하기

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// 연산 클래스
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
    public static int[] dr = {1, 0, -1, 0}; // 아래 -> 오른쪽 -> 위쪽 -> 왼쪽 사방탐색
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
        
        while(startR < endR && startC < endC) { // 시작 지점이 종료 지점보다 작을 때까지
        	int i = startR;
        	int j = startC;
        	int d = 0;
        	
        	int first = newArr[i][j]; // 시작 값 저장
        	
        	while(d != 4) { // 4방향 회전
        		int nr = i + dr[d];
        		int nc = j + dc[d];
        		
        		if(nr == startR && nc == startC) { // 처음 시작한 자리로 돌아오면 저장해둔 값 저장하고 회전 종료
        			newArr[i][j] = first;
        			break;
        		}
        		
        		if(nr < startR || nr > endR || nc < startC || nc > endC) { // 범위를 벗어나면 방향 회전
        			d++;
        			continue;
        		}
        		
        		newArr[i][j] = newArr[nr][nc];
        		
        		i = nr;
        		j = nc;
        	}
        	
        	startR++; // 안쪽으로 이동
        	startC++;
        	endR--;
        	endC--;
        }
    }
	
	public static boolean nextPermutation() {
		// 1. 꼭대기 찾기
		int peak = np.length - 1;
		
		while(peak > 0 && np[peak - 1] >= np[peak]) peak--;
		
		// 마지막 순열인 경우 더 이상 진행할 수 없으므로 return;
		if(peak == 0) return false;
		
		// 2. 교환할 자리 찾기
		int change = np.length - 1;
		
		while(np[peak - 1] >= np[change]) change--;
		
		// 3. 교환
		swap(peak - 1, change);
		
		int last = np.length - 1;
		
		// 4. 꼭대기부터 오름차순 정렬
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
	    	np[i] = i; // 리스트 인덱스를 담은 배열(오름차순 정렬)
	    
	    int answer = Integer.MAX_VALUE;
	    
	    do {
			newArr = new int[n][m];
			
			for(int i = 0; i < n; i++) { // 원본 배열 복사
				for(int j = 0; j < m; j++)
					newArr[i][j] = arr[i][j];
			}
			
			for(int i = 0; i < np.length; i++) {
				Operation op = list.get(np[i]); 
				rotation(op.r, op.c, op.s); // 정해진 순열 순서로 연산 진행
			}
			
			int minSum = Integer.MAX_VALUE;
			
			for(int i = 0; i < n; i++) { // 바뀐 배열을 행마다 돌면서 최솟값 찾기
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