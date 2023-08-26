import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Student{
	int num, like[];
	public Student(int[] like) {
		this.like = like;
	}
	
	public Student(int num, int[] like) {
		this.num = num;
		this.like = like;
	}
}

class Seat implements Comparable<Seat>{
	int r, c, like, empty;
	
	public Seat(int r, int c, int like, int empty) {
		this.r = r;
		this.c = c;
		this.like = like;
		this.empty = empty;
	}

	@Override
	public int compareTo(Seat o) {
		if(this.like == o.like) {
			if(this.empty == o.empty) {
				if(this.r == o.r)
					return this.c - o.c;
				return this.r - o.r;
			}
			return o.empty - this.empty;
		}
		return o.like - this.like;
	}
}

public class Main {
	public static int[][] classroom;
	public static int[] score = {0, 1, 10, 100, 1000};
	
	public static int n;
	public static int[] dr = {-1, 1, 0, 0};
	public static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		classroom = new int[n][n];
		ArrayList<Student> students = new ArrayList<>();
		Student[] students2 = new Student[n * n + 1];
		
		for(int i = 0; i < n * n; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			
			int[] like = new int[4];
			
			for(int j = 0; j < 4; j++)
				like[j] = Integer.parseInt(st.nextToken());
		
			students.add(new Student(num, like));
			students2[num] = new Student(like);
		}
		
		for(Student s : students)
			assignSeats(s);
		
		int answer = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				int s = classroom[i][j];
				
				int cnt = 0;
				for(int d = 0; d < 4; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];
					
					if(nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
					
					for(int k = 0; k < 4; k++) {
						if(classroom[nr][nc] == students2[s].like[k]) {
							cnt++;
							break;
						}
					}
				}
				
				answer += score[cnt];
			}
		}
		
		System.out.println(answer);
	}

	public static void assignSeats(Student s) {
		PriorityQueue<Seat> pq = new PriorityQueue<>();
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(classroom[i][j] == 0) {
					int empty = 0;
					int like = 0;
					
					for(int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						
						if(nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
						
						if(classroom[nr][nc] == 0) {
							empty++;
							continue;
						}
						
						for(int k = 0; k < 4; k++) {
							if(classroom[nr][nc] == s.like[k]) {
								like++;
								break;
							}
						}
					}
				
					pq.offer(new Seat(i, j, like, empty));
				}
			}
		}
		
		Seat selectedSeat = pq.poll();
		classroom[selectedSeat.r][selectedSeat.c] = s.num;
	}	
}