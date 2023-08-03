import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Ingredient{
	int sour;
	int bitter;
	
	public Ingredient(int sour, int bitter) {
		this.sour = sour;
		this.bitter = bitter;
	}
}

public class Main {
	static int n;
	static long min;
	static ArrayList<Ingredient> list = new ArrayList<>();
	
	static void chooseIngredient(int r, long sour, long bitter) {
		if(r == n) {
			if(bitter != 0) 
				min = Math.min(min, Math.abs(sour - bitter));
			
			return;
		}
		
		chooseIngredient(r + 1, sour * list.get(r).sour, bitter + list.get(r).bitter);
		chooseIngredient(r + 1, sour, bitter);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.add(new Ingredient(s, b));
		}
		
		min = Integer.MAX_VALUE;

		chooseIngredient(0, 1, 0);
		System.out.println(min);
	}

}