import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static Deque<Integer> before;
	
	public static void shake(int K) {
		Deque<Integer> result = new ArrayDeque<Integer>();
		Deque<Integer> temp = new ArrayDeque<Integer>();
		for(int i = K; i >= 0; i--) {
			int cnt = before.size() - (int)(Math.pow(2, i));
			while(cnt-- > 0)
				temp.offerLast(before.pollFirst());

			while(!temp.isEmpty())
				result.offerFirst(temp.pollLast());
		}
		
		while(!result.isEmpty())
			before.offerLast(result.pollFirst());
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] cards = new int[N];
		for(int i = 0; i < N; i++)
			cards[i] = Integer.parseInt(st.nextToken());
		
		before = new ArrayDeque<Integer>();
		
		int[] answer = new int[2];
		
		int start = 1;
		int k = 0;
		while(start < N) {
			start *= 2;
			k++;
		}
		
		outer : for(int i = 1; i < k; i++) {
			for(int j = 1; j < k; j++) {
				for(int t = 1; t <= N; t++)
					before.offer(t);
				
				shake(i);
				shake(j);
				
				int cnt = 0;
				
				for(int t = 0; t < N; t++) {
					if(before.pollFirst() == cards[t])
						cnt++;
				}
				
				if(cnt == N) {
					answer[0] = i;
					answer[1] = j;
					break outer;
				}
			}
		}
		
		System.out.println(answer[0] + " " + answer[1]);
	}

}