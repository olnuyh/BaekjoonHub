import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		
		int[] blocks = new int[w];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < w; i++)
			blocks[i] = Integer.parseInt(st.nextToken());
		
		int rainWater = 0;

		for(int i = 1; i < w - 1; i++) {
			int leftMax = 0;
			for(int j = 0; j < i; j++)
				leftMax = Math.max(leftMax, blocks[j]);
			
			int rightMax = 0;
			for(int j = i + 1; j < w; j++)
				rightMax = Math.max(rightMax, blocks[j]);
			
			if(leftMax < blocks[i] || rightMax < blocks[i])
				continue;
			
			rainWater += Math.min(leftMax, rightMax) - blocks[i];
		}
		
		System.out.println(rainWater);
	}

}