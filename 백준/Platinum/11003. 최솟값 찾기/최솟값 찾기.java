import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(stk.nextToken());
		int l = Integer.parseInt(stk.nextToken());
		
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		int value[] = new int[n];
		
		stk = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			value[i] = Integer.parseInt(stk.nextToken());
			
			while(!deque.isEmpty() && value[deque.getLast()] > value[i])
				deque.removeLast();
			
			deque.addLast(i);
			
			if(deque.getFirst() <= i - l)
				deque.removeFirst();
			
			bw.write(value[deque.getFirst()] + " ");
		}
		bw.flush();
		bw.close();
	}
}