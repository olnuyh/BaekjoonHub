import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int[] lis;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] target = new int[N + 1];
		for(int i = 1; i <= N; i++)
			target[i] = Integer.parseInt(st.nextToken());
		lis = new int[N + 1];
		
		int maxCnt = 0;

		for(int i = 1; i <= N; i++) {
			if(target[i] > lis[maxCnt]) {
				lis[++maxCnt] = target[i];
			}else {
				int pos = binarySearch(0, maxCnt, target[i]);
				lis[pos] = target[i];
			}
		}
		
		System.out.println(N - maxCnt);
	}
	
	public static int binarySearch(int start, int end, int val) {		
		while(start < end) {
			int mid = (start + end) / 2;
			
			if(lis[mid] < val)
				start = mid + 1;
			else
				end = mid;
		}
		
		return end;
	}
}