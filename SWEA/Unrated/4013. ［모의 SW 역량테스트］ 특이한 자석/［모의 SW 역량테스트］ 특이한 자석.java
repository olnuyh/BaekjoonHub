import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static int[][] score = {{0, 1}, {0, 2}, {0, 4}, {0, 8}};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());

		for(int tc = 1; tc <= t; tc++) {
			int k = Integer.parseInt(br.readLine());
			
			int[][] magnet = new int[4][8];
			
			for(int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 8; j++)
					magnet[i][j] = Integer.parseInt(st.nextToken());
			}

			for(int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int magnetNum = Integer.parseInt(st.nextToken()) - 1;
				int dir = Integer.parseInt(st.nextToken());
				
				int[] rotation = new int[4];
				rotation[magnetNum] = dir;
				
				for(int j = magnetNum + 1; j < 4; j++) {
					if(magnet[j - 1][2] == magnet[j][6])
						break;
					else
						rotation[j] = -rotation[j - 1];
				}
				
				for(int j = magnetNum - 1; j >= 0; j--) {
					if(magnet[j][2] == magnet[j + 1][6])
						break;
					else
						rotation[j] = -rotation[j + 1];
				}
				
				for(int j = 0; j < 4; j++) {
					if(rotation[j] == 0)
						continue;
					
					if(rotation[j] == 1) {
						int tmp = magnet[j][7];
						for(int p = 7; p > 0; p--)
							magnet[j][p] = magnet[j][p - 1];
						magnet[j][0] = tmp;
					}else {
						int tmp = magnet[j][0];
						for(int p = 0; p < 7; p++)
							magnet[j][p] = magnet[j][p + 1];
						magnet[j][7] = tmp;
					}
				}
			}
			
			int result = 0;
			for(int i = 0; i < 4; i++) 
				result += score[i][magnet[i][0]];
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		
		System.out.println(sb);
	}

}