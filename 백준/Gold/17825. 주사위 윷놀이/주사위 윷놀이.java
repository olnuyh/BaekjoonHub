import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int maxScore;
	public static int[] dice;
	public static int[][] board = {{0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 0}, 
									{10, 13, 16, 19, 25, 30, 35, 40, 0},
									{20, 22, 24, 25, 30, 35, 40, 0},
									{30, 28, 27, 26, 25, 30, 35, 40, 0}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		dice = new int[10];
		for(int i = 0; i < 10; i++)
			dice[i] = Integer.parseInt(st.nextToken());
		
		maxScore = 0;
		setOrder(0, new int[10]);
		
		System.out.println(maxScore);
	}

	public static void setOrder(int cnt, int[] selected) {
		if(cnt == 10) {
			calcScore(selected);
			//maxScore = Math.max(maxScore, calcScore(selected));
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			selected[cnt] = i;
			setOrder(cnt + 1, selected);
		}
	}
	
	public static void calcScore(int[] order) {
		int[][] pos = new int[4][2]; // {경로, 위치}
 		int score = 0;
		
		for(int i = 0; i < 10; i++) {
			
			int[] cur = pos[order[i]]; // 이동하려는 말의 현재 위치
			
			if(cur[1] + dice[i] >= board[cur[0]].length) { // 도착점에 도달하거나 넘어가면 끝
				pos[order[i]][0] = cur[0];
				pos[order[i]][1] = board[cur[0]].length - 1;
				continue;
			}
			
			int[] next = {cur[0], cur[1] + dice[i]};
			
			if(next[0] == 0) { // 파란색 화살표 타도록 경로 바꿔주기
				if(next[1] == 5) {
					next[0] = 1;
					next[1] = 0;
				}else if(next[1] == 10) {
					next[0] = 2;
					next[1] = 0;
				}else if(next[1] == 15) {
					next[0] = 3;
					next[1] = 0;
				}
			}
			
			boolean canMove = true;
			
			for(int j = 0; j < 4; j++) {
				if(order[i] == j) continue;
				
				if(pos[j][0] == next[0] && pos[j][1] == next[1]) {
					canMove = false;
					break;
				}
				
				if(board[next[0]][next[1]] == 25 && board[pos[j][0]][pos[j][1]] == 25) {
					canMove = false;
					break;
				}
				
				if(board[next[0]][next[1]] == 30 && board[pos[j][0]][pos[j][1]] == 30 && next[1] != 0 && pos[j][1] != 0) {
					canMove = false;
					break;
				}
				
				if(board[next[0]][next[1]] == 35 && board[pos[j][0]][pos[j][1]] == 35) {
					canMove = false;
					break;
				}
				
				if(board[next[0]][next[1]] == 40 && board[pos[j][0]][pos[j][1]] == 40) {
					canMove = false;
					break;
				}
				
			}
			
			if(canMove) {
				pos[order[i]][0] = next[0];
				pos[order[i]][1] = next[1];
				score += board[next[0]][next[1]];
			}else
				return;
		}
		
		maxScore = Math.max(maxScore, score);
	}
}