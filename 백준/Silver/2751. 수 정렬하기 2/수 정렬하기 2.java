import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{
	public static int[] A;
	public static int[] tmp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		A = new int[n];
		tmp = new int[n];
		
		for(int i = 0; i < n; i++)
			A[i] = Integer.parseInt(br.readLine());
		
		mergeSort(0, n - 1);
		
		for(int i = 0; i < n; i++)
			bw.write(A[i] + "\n");
		
		bw.flush();
		bw.close();
	}
	
	public static void mergeSort(int s, int e) {
		if(e - s < 1)
			return;
		int m = (s + e) / 2;
		
		mergeSort(s, m);
		mergeSort(m + 1, e);
		
		for(int i = s; i <= e; i++)
			tmp[i] = A[i];
		
		int index1 = s;
		int index2 = m + 1;
		int k = s;
		
		while(index1 <= m && index2 <= e) {
			if(tmp[index1] < tmp[index2]) {
				A[k] = tmp[index1];
				k++;
				index1++;
			}
			else {
				A[k] = tmp[index2];
				k++;
				index2++;
			}
		}
		
		while(index1 <= m) {
			A[k] = tmp[index1];
			k++;
			index1++;
		}
		
		while(index2 <= e) {
			A[k] = tmp[index2];
			k++;
			index2++;
		}
	}
}