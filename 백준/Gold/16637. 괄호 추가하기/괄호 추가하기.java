import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	public static int n;
	public static int[] num;
	public static char[] oper;
	public static int maxResult;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		
		num = new int[n / 2 + 1];
		oper = new char[n / 2];
		
		for(int i = 0, j = 0, k = 0; i < str.length(); i++) {
			if(i % 2 != 0)
				oper[j++] = str.charAt(i);
			else
				num[k++] = str.charAt(i) - '0';
		}
		
		maxResult = Integer.MIN_VALUE;
		subSet(0, new boolean[n / 2]);
		
		System.out.println(maxResult);
	}

	public static void subSet(int cnt, boolean[] existence) {
		if(cnt == n / 2) {
			int result = num[0];
			boolean[] visited = new boolean[n / 2];
			
			for(int i = 0; i < n / 2; i++) {
				if(visited[i]) continue;
				
				if(i == n / 2 - 1) {
					result = calc(result, num[i + 1], oper[i]);
					continue;
				}
				
				if(existence[i + 1]) {
					result = calc(result, calc(num[i + 1], num[i + 2], oper[i + 1]), oper[i]);
					visited[i + 1] = true;
				}else {
					result = calc(result, num[i + 1], oper[i]);
				}
			}

			maxResult = Math.max(maxResult, result);
			return;
		}
		
		existence[cnt] = true;
		if(cnt == 0 || !existence[cnt - 1])
			subSet(cnt + 1, existence);
		existence[cnt] = false;
		subSet(cnt + 1, existence);
	}
	
	public static int calc(int a, int b, char c) {
		switch(c) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		}
		
		return 0;
	}
}