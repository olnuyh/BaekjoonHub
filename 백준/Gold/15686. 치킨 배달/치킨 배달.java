import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static boolean[] isSelected;
	public static ArrayList<int[]> house;
	public static ArrayList<int[]> chickenHouse;
	public static int chickenDistance;
	public static int minChickenDistance;
	public static int m;
	
	public static void sub(int cnt, int selectedCnt) {
		if(cnt == chickenHouse.size()) {
			if(selectedCnt == 0 || selectedCnt > m) return;
			
			chickenDistance = 0;
			for(int i = 0; i < house.size(); i++) {
				int dist = Integer.MAX_VALUE;
				for(int j = 0; j < chickenHouse.size(); j++) {
					if(isSelected[j]) {
						int[] h = house.get(i);
						int[] c = chickenHouse.get(j);
						dist = Math.min(dist, Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]));
					}
				}
				chickenDistance += dist;
			}
			
			minChickenDistance = Math.min(minChickenDistance, chickenDistance);
			return;
		}
		
		isSelected[cnt] = true;
		sub(cnt + 1, selectedCnt + 1);
		isSelected[cnt] = false;
		sub(cnt + 1, selectedCnt);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		house = new ArrayList<>();
		chickenHouse = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num == 1)
					house.add(new int[] {i, j});
				else if(num == 2)
					chickenHouse.add(new int[] {i, j});
			}
		}
		
		minChickenDistance = Integer.MAX_VALUE;
		isSelected = new boolean[chickenHouse.size()];
		sub(0, 0);
		
		System.out.println(minChickenDistance);
	}

}