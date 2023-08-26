import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] durability = new int[2 * n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 2 * n; i++)
			durability[i] = Integer.parseInt(st.nextToken());
		
		int stage = 1;
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] robot = new boolean[2 * n];
		
		while(true) {
			// 1. 벨트 + 로봇 회전
			int tempBelt = durability[2 * n - 1];
			boolean tempRobot = robot[2 * n - 1];
			
			for(int i = 2 * n - 1; i > 0; i--) {
				durability[i] = durability[i - 1];
				robot[i] = robot[i - 1];
			}
			
			durability[0] = tempBelt;
			robot[0] = tempRobot;
			
			// 2. 로봇 이동
			if(!q.isEmpty()) {
				int size = q.size();
				
				for(int i = 0; i < size; i++) {
					int pos = q.poll();
					
					if(pos + 1 == n - 1) { // 벨트가 회전했을 때 내리는 위치에 오면 삭제
						robot[pos + 1] = false;
						continue;
					}
					
					if(!robot[pos + 2] && durability[pos + 2] >= 1) { // 로봇 이동이 가능할 때
						durability[pos + 2] -= 1;
						robot[pos + 1] = false;
						if(pos + 2 != n - 1) { // 내리는 위치에 도달하지 않을 경우 다시 로봇 큐에 추가
							q.add(pos + 2);
							robot[pos + 2] = true;
						}
					}else // 로봇 이동이 불가능할 때
						q.add(pos + 1);
				}
			}
			
			// 3. 로봇 올리기
			if(durability[0] > 0) {
				q.add(0);
				durability[0] -= 1;
				robot[0] = true;
			}
			
			// 4. 내구도가 0인 칸 개수 확인
			int cnt = 0;
			for(int i = 0; i < 2 * n; i++) {
				if(durability[i] == 0)
					cnt++;
			}
			
			if(cnt >= k)
				break;
			else
				stage++;
		}
		
		System.out.println(stage);
	}

}