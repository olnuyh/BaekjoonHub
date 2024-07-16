import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int[][] deltas = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String original = "123456780";

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                answer.append(st.nextToken());
            }
        }

        int minCnt = move(original, answer.toString());

        System.out.println(minCnt);
    }

    public static int move (String original, String answer) {
        HashMap<String, Integer> visited = new HashMap<>();
        visited.put(original, 0);

        Queue<String> q = new ArrayDeque<>();
        q.offer(original);

        while (!q.isEmpty()) {
            String cur = q.poll();

            if (cur.equals(answer)) {
                return visited.get(cur);
            }

            int blank = cur.indexOf('0');

            for (int i = 0; i < 4; i++) {
                int nr = blank / 3 + deltas[i][0];
                int nc = blank % 3 + deltas[i][1];

                if (nr < 0 || nr >= 3 || nc < 0 || nc >= 3) {
                    continue;
                }

                StringBuilder next = new StringBuilder(cur);
                char ch = next.charAt(nr * 3 + nc);
                next.setCharAt(blank, ch);
                next.setCharAt(nr * 3 + nc, '0');

                if (!visited.containsKey(next.toString())) {
                    q.offer(next.toString());
                    visited.put(next.toString(), visited.getOrDefault(cur, 0) + 1);
                }
            }
        }

        return -1;
    }
}