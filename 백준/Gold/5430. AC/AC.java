import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < t; tc++) {
			String command = br.readLine();
			
			int n = Integer.parseInt(br.readLine());
			
			Deque<Integer> dq = new ArrayDeque<>();
			String temp = br.readLine();
			String[] arr = temp.substring(1, temp.length() - 1).split(",");
			
			if(!temp.equals("[]")) {
			for(int i = 0; i < arr.length; i++)
				dq.add(Integer.parseInt(arr[i]));
			}
			
			boolean front = true;
			boolean isError = false;
			
			for(int i = 0; i < command.length(); i++) {
				char c = command.charAt(i);
				
				if(c == 'R') {
					front = !front;
				}else {
					if(dq.isEmpty()) {
						isError = true;
						break;
					}
					else {
						if(front)
							dq.pollFirst();
						else
							dq.pollLast();
					}
				}
			}
			
			if(isError)
				sb.append("error\n");
			else {
				sb.append("[");
				
				int size = dq.size();
				for(int i = 0; i < size; i++) {
					if(front)
						sb.append(dq.pollFirst());
					else
						sb.append(dq.pollLast());
					
					if(i != size - 1)
						sb.append(",");
				}
				
				sb.append("]\n");
			}
		}
		
		System.out.println(sb);
	}

}