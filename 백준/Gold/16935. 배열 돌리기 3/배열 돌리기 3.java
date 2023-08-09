import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[][] arr;
	public static int[][] temp;
	
	public static void oper1() {
		int n = arr.length;
		int m = arr[0].length;
		
		temp = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) 
				temp[i][j] = arr[n - 1 - i][j];
		}
		
		arr = temp;
	}
	
	public static void oper2() {
		int n = arr.length;
		int m = arr[0].length;
		
		temp = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) 
				temp[i][j] = arr[i][m - 1 - j];
		}
		
		arr = temp;
	}
	
	public static void oper3() {
		int n = arr.length;
		int m = arr[0].length;
		
		temp = new int[m][n];
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++)
				temp[i][j] = arr[n - 1 - j][i];
		}
		
		arr = temp;
	}
	
	public static void oper4() {
		int n = arr.length;
		int m = arr[0].length;
		
		temp = new int[m][n];
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) 
				temp[i][j] = arr[j][m - 1 - i];
		}
		
		arr = temp;
	}
	
	public static void oper5() {
		int n = arr.length;
		int m = arr[0].length;
		
		temp = new int[n][m];
		
		for(int i = 0; i < n / 2; i++) {
			for(int j = 0; j < m / 2; j++) 
				temp[i][j] = arr[i + n / 2][j];
			
			for(int j = m / 2; j < m; j++)
				temp[i][j] = arr[i][j - m / 2];
		}
		
		for(int i = n / 2; i < n; i++) {
			for(int j = 0; j < m / 2; j++)
				temp[i][j] = arr[i][j + m / 2];
			
			for(int j = m / 2; j < m; j++)
				temp[i][j] = arr[i - n / 2][j];
		}
		
		arr = temp;
	}
	
	public static void oper6() {
		int n = arr.length;
		int m = arr[0].length;
		
		temp = new int[n][m];
		
		for(int i = 0; i < n/ 2; i++) {
			for(int j = 0; j < m / 2; j++) 
				temp[i][j] = arr[i][j + m / 2];
			
			for(int j = m / 2; j < m; j++)
				temp[i][j] = arr[i + n / 2][j];
		}
		
		for(int i = n / 2; i < n; i++) {
			for(int j = 0; j < m / 2; j++)
				temp[i][j] = arr[i - n / 2][j];
			
			for(int j = m / 2; j < m; j++)
				temp[i][j] = arr[i][j - m / 2];
		}
		
		arr = temp;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int[] command = new int[r];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < r; i++)
			command[i] = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < r; i++) {
			switch(command[i]) {
			case 1:
				oper1();
				break;
				
			case 2:
				oper2();
				break;
			
			case 3:
				oper3();
				break;
			
			case 4:
				oper4();
				break;
				
			case 5:
				oper5();
				break;
				
			case 6:
				oper6();
				break;
			}
		}
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}