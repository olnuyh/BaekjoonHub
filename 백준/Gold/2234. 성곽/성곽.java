import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int[][] deltas = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    public static int[][] castle;
    public static int[][] visited;
    public static int maxRoom;
    public static int maxRoomWithoutWall;
    public static int M, N;
    public static List<Integer> rooms;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        castle = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                castle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new int[M][N];
        maxRoom = 0;
        maxRoomWithoutWall = 0;
        rooms = new ArrayList<>();

        int roomCount = 1;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == 0) {
                    bfs(i, j, roomCount);
                    roomCount++;
                }
            }
        }

        check();

        sb.append(roomCount - 1).append("\n");
        sb.append(maxRoom).append("\n");
        sb.append(maxRoomWithoutWall).append("\n");

        System.out.println(sb);
    }

    public static void bfs (int sr, int sc, int num) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc});

        visited[sr][sc] = num;

        int count = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int d = 0; d < 4; d++) {
                if ((castle[cur[0]][cur[1]] & (int) Math.pow(2, d)) == 0) {
                    int nr = cur[0] + deltas[d][0];
                    int nc = cur[1] + deltas[d][1];

                    if (visited[nr][nc] == 0) {
                        visited[nr][nc] = num;
                        q.offer(new int[]{nr, nc});
                        count++;
                    }
                }
            }
        }

        rooms.add(count);
        maxRoom = Math.max(maxRoom, count);
    }

    public static void check () {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                for (int d = 0; d < 4; d++) {
                    if ((castle[i][j] & (int) Math.pow(2, d)) > 0) {
                        int nr = i + deltas[d][0];
                        int nc = j + deltas[d][1];

                        if (isIn(nr, nc) && visited[i][j] != visited[nr][nc]) {
                            maxRoomWithoutWall = Math.max(maxRoomWithoutWall, rooms.get(visited[i][j] - 1) + rooms.get(visited[nr][nc] - 1));
                        }
                    }
                }
            }
        }
    }

    public static boolean isIn (int r, int c) {
        return r >= 0 && r < M && c >= 0 && c < N;
    }
}