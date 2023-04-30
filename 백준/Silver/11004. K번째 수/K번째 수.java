import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(stk.nextToken());
		int k = Integer.parseInt(stk.nextToken());
		
		stk = new StringTokenizer(br.readLine());
		int[] A = new int[n];
		for(int i = 0; i < n ; i++)
			A[i] = Integer.parseInt(stk.nextToken());
		
		quickSort(A, 0, n - 1, k - 1);
		System.out.println(A[k - 1]);
	}
	
	public static void quickSort(int[] A, int s, int e, int k) {
		int pivot = partition(A, s, e);
		if(pivot == k)
			return;
		else if(pivot > k)
			quickSort(A, s, pivot - 1, k);
		else
			quickSort(A, pivot + 1, e, k);
	}
	
	public static int partition(int[] A, int s, int e) {
		if(s + 1 == e) {
			if(A[s] > A[e]) {
				swap(A, s, e);
				return s;
			}
		}
		
		int m = (s + e) / 2;
		swap(A, s, m);
		int pivot = A[s];
		int start = s + 1;
		int end = e;
		
		while(start <= end) {
			while(start <= e && A[start] < pivot)
				start++;
			while(end >= s + 1 && A[end] > pivot)
				end--;
			if(start <= end)
				swap(A, start++, end--);
		}
		
		A[s] = A[end];
		A[end] = pivot;
		return end;
	}
	
	public static void swap(int[] A, int a, int b) {
		int temp = A[a];
		A[a] = A[b];
		A[b] = temp;
	}
}