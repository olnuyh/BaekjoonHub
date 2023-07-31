import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashMap<Integer, Integer> hm = new HashMap<>();
		
		int r = Integer.parseInt(st.nextToken()) - 1;
		int c = Integer.parseInt(st.nextToken()) - 1;
		int k = Integer.parseInt(st.nextToken());
		
		int[][] A = new int[100][100];
		
		for(int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++)
				A[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int w = 3; // 열의 개수
		int h = 3; // 행의 개수
		
		int answer = -1;
		
		for(int t = 0; t <= 100; t++) {
			if(A[r][c] == k) {
				answer = t;
				break;
			}
			
			if(h >= w) { // R연산
				int temp = 0;
				for(int i = 0; i < h; i++) {				
					for(int j = 0; j < w; j++) {
						if(A[i][j] == 0)
							continue;
						hm.put(A[i][j], hm.getOrDefault(A[i][j], 0) + 1);
						A[i][j] = 0;
					}
					List<Integer> keys = new ArrayList<>(hm.keySet());
					Collections.sort(keys, new Comparator<Integer>(){

						@Override
						public int compare(Integer o1, Integer o2) {
							if(hm.get(o1) == hm.get(o2))
								return o1- o2;
							return hm.get(o1) - hm.get(o2);
						}
						
					});
					
					for(int j = 0; j < keys.size(); j++) {
						if(j >= 50)
							break;
						
						A[i][2 * j] = keys.get(j);
						A[i][2 * j + 1] = hm.get(keys.get(j));
					}
					
					temp = Math.max(temp, 2 * keys.size());
					
					hm.clear();
					
					if(i == h - 1) {
						if(temp > 100)
							w = 100;
						else
							w = temp;
					}
				}
			}else { // C연산
				
				int temp = 0;
				for(int i = 0; i < w; i++) {				
					for(int j = 0; j < h; j++) {
						if(A[j][i] == 0)
							continue;
						hm.put(A[j][i], hm.getOrDefault(A[j][i], 0) + 1);
						A[j][i] = 0;
					}
					List<Integer> keys = new ArrayList<>(hm.keySet());
					Collections.sort(keys, new Comparator<Integer>(){

						@Override
						public int compare(Integer o1, Integer o2) {
							if(hm.get(o1) == hm.get(o2))
								return o1- o2;
							return hm.get(o1) - hm.get(o2);
						}
												
					});
					
					for(int j = 0; j < keys.size(); j++) {
						if(j >= 50)
							break;
						
						A[2 * j][i] = keys.get(j);
						A[2 * j + 1][i] = hm.get(keys.get(j));
					}
					
					temp = Math.max(temp, 2 * keys.size());
					
					hm.clear();
					
					if(i == w - 1) {
						if(temp > 100)
							h = 100;
						else
							h = temp;
					}
			}
		}
	}
		
		System.out.println(answer);
	}
}