import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t <= 10; t++) {
			int tc = Integer.parseInt(br.readLine());
			
			Queue<Integer> queue = new ArrayDeque<>();
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < 8; i++)
				queue.offer(Integer.parseInt(st.nextToken()));
			
			int d = 1;
			
			while(true) {
				int temp = queue.poll();
				
				if(temp - d <= 0) {
					queue.offer(0);
					break;
				}
				
				queue.offer(temp - d);
				
				d = (d + 1) % 6;
				
				if(d == 0)
					d = 1;
			}
			
			sb.append("#").append(tc).append(" ");
			
			for(int i = 0; i < 8; i++)
				sb.append(queue.poll()).append(" ");
			sb.append("\n");
		}

		System.out.println(sb);
	}

}