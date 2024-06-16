import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Room implements Comparable<Room>{
        int r, c, wall;

        public Room(int r, int c, int wall) {
            this.r = r;
            this.c = c;
            this.wall = wall;
        }

        @Override
        public int compareTo(Room o) {
            return this.wall - o.wall;
        }
    }

    public static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static int M, N;
    public static int[][] maze;
    public static int[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        maze = new int[N][M];
        result = new int[N][M];

        for (int i = 0; i < N; i++) {
            char[] tmp = br.readLine().toCharArray();

            for (int j = 0; j < M; j++) {
                maze[i][j] = tmp[j] - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                result[i][j] = Integer.MAX_VALUE;
            }
        }

        move();

        System.out.println(result[N - 1][M - 1]);
    }

    public static void move() {
        Deque<int[]> dq = new ArrayDeque<>();
        result[0][0] = 0;
        dq.add(new int[]{0, 0});

        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + deltas[i][0];
                int nc = cur[1] + deltas[i][1];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M || result[nr][nc] != Integer.MAX_VALUE) {
                    continue;
                }

                if (result[nr][nc] > result[cur[0]][cur[1]] + maze[nr][nc]) {
                    result[nr][nc] = result[cur[0]][cur[1]] + maze[nr][nc];

                    if (maze[nr][nc] == 0) {
                        dq.addFirst(new int[]{nr, nc});
                    } else {
                        dq.addLast(new int[]{nr, nc});
                    }
                }
            }
        }
    }
}