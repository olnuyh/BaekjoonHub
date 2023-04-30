import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Num[] A = new Num[n];
		
		for(int i = 0; i < n; i++)
			A[i] = new Num(Integer.parseInt(br.readLine()), i);
		
		Arrays.sort(A);
		
		int answer = 0;
		for(int i = 0; i < n; i++) {
			if(answer < A[i].index - i)
				answer = A[i].index - i;
		}
		
		System.out.println(answer + 1);
	}
}

class Num implements Comparable<Num>{
	int value;
	int index;
	
	public Num(int value, int index) {
		this.value = value;
		this.index = index;
	}

	@Override
	public int compareTo(Num o) {
		return this.value - o.value;
	}
}