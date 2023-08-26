import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
		boolean[] robot = new boolean[n];
		
		while(true) {
			// 1. 벨트 + 로봇 회전
			int tempBelt = durability[2 * n - 1];
			
			for(int i = 2 * n - 1; i > 0; i--)
				durability[i] = durability[i - 1];
			durability[0] = tempBelt;
			
			for(int i = n - 1; i > 0; i--)
				robot[i] = robot[i - 1];
			robot[0] = false;
			robot[n - 1] = false; // 벨트 회전 시 내리는 위치에 오면 로봇 제거
			
			// 2. 로봇 이동
			for(int i = n - 1; i > 0; i--) {
				if(robot[i - 1] && !robot[i] && durability[i] >= 1) {
					robot[i] = true;
					robot[i - 1] = false;
					durability[i] -= 1;
				}
			}
			
			// 3. 올리는 위치에 로봇 올리기
			if(durability[0] > 0) {
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