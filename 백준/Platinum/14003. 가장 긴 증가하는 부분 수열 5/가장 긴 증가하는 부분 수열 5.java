import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int binarySearch(int start, int end, int target) {
		while(start<end) {
			int mid = (start+end)/2;
			if(lis.get(mid) == target) {
				return mid;
			}
			if(lis.get(mid) < target) {
				start = mid+1;
			}
			else {
				end = mid;
			}
		}
		return end;
	}
	
	static class Node{
		int v,i;

		public Node(int v, int i) {
			this.v = v;
			this.i = i;
		}
	}
	static List<Integer> lis = new ArrayList<>();	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st= new StringTokenizer(br.readLine());
		List<Node> res = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		lis.add(Integer.parseInt(st.nextToken()));
		res.add(new Node(lis.get(0),0));
		for(int i=1; i<n; i++) {
			int next = Integer.parseInt(st.nextToken());
			
			if(lis.get(lis.size()-1) < next) {
				lis.add(next);
				res.add(new Node(next,lis.size()-1));
			}
			else{
				int idx = binarySearch(0, lis.size()-1, next);
				res.add(new Node(next,idx));
				lis.set(idx, next);
			}
		}
		sb.append(lis.size()).append("\n");
		int idx = lis.size()-1;
		for(int i=res.size()-1; i>=0; i--) {
			if(res.get(i).i == idx) {
				lis.set(idx,res.get(i).v);
				idx--;
			}
		}
		for(int i:lis) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);
	}

}