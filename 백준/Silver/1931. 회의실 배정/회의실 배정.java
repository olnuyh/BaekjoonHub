import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Meeting implements Comparable<Meeting>{
	int startTime, endTime;
	
	public Meeting(int startTime, int endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public int compareTo(Meeting m) {
		if(this.endTime == m.endTime)
			return this.startTime - m.startTime;
		return this.endTime - m.endTime;
	}
}

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		Meeting[] list = new Meeting[n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			list[i] = new Meeting(s, e);
		}
		
		Arrays.sort(list);
		
		int cnt = 0;
		int selectedEndTime = 0;
		for(int i = 0; i < n; i++) {
			if(list[i].startTime >= selectedEndTime) {
				selectedEndTime = list[i].endTime;
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}