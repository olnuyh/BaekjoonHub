import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static int[][] deltas = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static char[][] students;
    public static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        students = new char[5][5];

        for (int i = 0; i < 5; i++) {
            students[i] = br.readLine().toCharArray();
        }

        answer = 0;

        makeCombi(0, new int[7], 0);

        System.out.println(answer);
    }

    public static void makeCombi (int depth, int[] selected, int start) {
        if (depth == 7) {
            int sCount = 0;

            for (int i = 0; i < 7; i++) {
                int r = selected[i] / 5;
                int c = selected[i] % 5;

                if (students[r][c] == 'S') {
                    sCount++;
                }
            }

            if (sCount < 4) {
                return;
            }

            if (check(selected)) {
                answer++;
            }

            return;
        }

        for (int i = start; i < 25; i++) {
            selected[depth] = i;
            makeCombi(depth + 1, selected, i + 1);
        }
    }

    public static boolean check (int[] selected) {
        int start = selected[0];

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);

        boolean[] visited = new boolean[25];
        visited[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cur / 5 + deltas[d][0];
                int nc = cur % 5 + deltas[d][1];

                int num = nr * 5 + nc;

                if (isIn(nr, nc) && !visited[num]) {
                    for (int s : selected) {
                        if (s == num) {
                            visited[num] = true;
                            q.offer(num);
                        }
                    }
                }
            }
        }

        for (int num : selected) {
            if (!visited[num]) {
                return false;
            }
        }

        return true;
    }

    public static boolean isIn (int r, int c) {
        return r >= 0 && r < 5 && c >= 0 && c < 5;
    }
}