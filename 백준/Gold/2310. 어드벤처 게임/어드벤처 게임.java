import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N;
    public static List<Integer>[] rooms;
    public static int[] payInfo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            N = Integer.parseInt(br.readLine());

            if (N == 0) {
                break;
            }

            rooms = new ArrayList[N + 1];

            for (int i = 1; i <= N; i++) {
                rooms[i] = new ArrayList<>();
            }

            payInfo = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());

                String content = st.nextToken();
                int pay = Integer.parseInt(st.nextToken());

                if (content.equals("T")) {
                    pay *= - 1;
                }

                payInfo[i] = pay;

                while (true) {
                    int room = Integer.parseInt(st.nextToken());

                    if (room == 0) {
                        break;
                    }

                    rooms[i].add(room);
                }
            }

            if (explore()) {
                sb.append("Yes\n");
            } else {
                sb.append("No\n");
            }
        }

        System.out.println(sb);
    }

    public static boolean explore () {
        int[] visited = new int[N + 1];
        visited[1] = 0;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{1, 0});

        while (!q.isEmpty()) {
            int[] tmp = q.poll();

            int curNum = tmp[0];
            int curMoney = tmp[1];

            if (payInfo[curNum] > 0) {
                if (curMoney < payInfo[curNum]) {
                    curMoney = payInfo[curNum];
                }
            } else if (payInfo[curNum] < 0) {
                if (curMoney + payInfo[curNum] < 0) {
                    continue;
                }

                curMoney += payInfo[curNum];
            }

            if (curNum == N && curMoney >= 0) {
                return true;
            }

            for (int next : rooms[curNum]) {
                if (visited[next] == 0 || visited[next] < curMoney) {
                    visited[next] = curMoney;
                    q.offer(new int[]{next, curMoney});
                }
            }
        }

        return false;
    }
}