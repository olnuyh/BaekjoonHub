import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		int[] A = new int[10001];
		
		for(int i = 0; i < n ; i++)
			A[Integer.parseInt(br.readLine())] += 1;
		
		for(int i = 0; i < 10001; i++) {
			if(A[i] != 0) {
				for(int j = 0; j < A[i]; j++)
					bw.write(i + "\n");
			}
		}
		bw.flush();
		bw.close();
	}
}