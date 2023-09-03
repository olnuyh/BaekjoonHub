import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	public static String[] nums = {"###...#.###.###.#.#.###.###.###.###.###", 
									"#.#...#...#...#.#.#.#...#.....#.#.#.#.#",
									"#.#...#.###.###.###.###.###...#.###.###",
									"#.#...#.#.....#...#...#.#.#...#.#.#...#",
									"###...#.###.###...#.###.###...#.###.###"};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		String[] floor = new String[5];
		for(int i = 0; i < 5; i++)
			floor[i] = br.readLine();
		
		ArrayList<Integer>[] list = new ArrayList[n];
		for(int i = 0; i < n; i++)
			list[i] = new ArrayList<>();
		
		for(int i = 0; i < 4 * n - 1; i += 4) {
			boolean[][] check = new boolean[5][3];
			for(int j = 0; j < 5; j++) {
				for(int k = i, cnt = 0; k < i + 3; k++) {
					if(floor[j].charAt(k) == '#')
						check[j][cnt++] = true;
					else
						check[j][cnt++] = false;
				}
			}
			
			for(int j = 0; j < 40; j += 4) {
				boolean isPossible = true;
				for(int k = 0; k < 5; k++) {
					for(int h = 0; h < 3; h++) {
						if(check[k][h] && nums[k].charAt(j + h) == '.') {
							isPossible = false;
							break;
						}
					}
				}
				
				if(isPossible)
					list[i / 4].add(j / 4);
			}
		}
		
		int count = 1;
		for(int i = 0; i < n; i++)
			count *= list[i].size();
		
		if(count == 0)
			System.out.println(-1);
		else {
			long sum = 0;
			for(int i = 0; i < n; i++) {
				int s = 0;
				for(int j = 0; j < list[i].size(); j++)
					s += list[i].get(j);
				sum += s * Math.pow(10, n - 1 - i) * count / list[i].size();
			}
			
			double result = sum * 1.0 / count;
			System.out.println(result);
		}
	}
}