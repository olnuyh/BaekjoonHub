import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int r, c;
	public static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		cnt = 0;
		spaceSearch(0, 0, (int)Math.pow(2, n));
	}

	private static void spaceSearch(int sr, int sc, int size) {
		if(sr == r && sc == c) {
			System.out.println(cnt);
			return;
		}
		
		if(r >= sr && r < sr + size && c >= sc && c < sc + size) {
			int half = size / 2;
			spaceSearch(sr, sc, half);
			spaceSearch(sr, sc + half, half);
			spaceSearch(sr + half, sc, half);
			spaceSearch(sr + half, sc + half, half);
		}
		else
			cnt += size * size;
	}
}