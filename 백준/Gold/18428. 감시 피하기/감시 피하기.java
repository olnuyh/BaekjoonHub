import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static int students;
    public static ArrayList<int[]> teachers;
    public static ArrayList<int[]> blanks;
    public static boolean[][] visited;
    public static boolean canAvoid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        char[][] hallway = new char[N][N];

        students = 0;
        teachers = new ArrayList<>();
        blanks = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                char tmp = st.nextToken().charAt(0);

                if (tmp == 'S') {
                    students++;
                } else if (tmp == 'T') {
                    teachers.add(new int[]{i, j});
                } else {
                    blanks.add(new int[]{i, j});
                }

                hallway[i][j] = tmp;
            }
        }

        canAvoid = false;

        installObjects(hallway, 0, 0);

        if (canAvoid) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void installObjects(char[][] hallway, int start, int cnt) {
        if (cnt == 3) {
            visited = new boolean[N][N];

            int found = 0;
            for (int i = 0; i < teachers.size(); i++) {
                found += findStudents(teachers.get(i), hallway);

                if (found == students) {
                    break;
                }
            }

            if (found == 0) {
                canAvoid = true;
            }

            return;
        }

        for (int i = start; i < blanks.size(); i++) {
            int[] object = blanks.get(i);
            hallway[object[0]][object[1]] = 'O';
            installObjects(hallway, i + 1, cnt + 1);
            hallway[object[0]][object[1]] = 'X';
        }
    }

    public static int findStudents(int[] teacher, char[][] hallway) {
        int found = 0;

        for (int i = 0; i < 4; i++) {
            for (int d = 1; ; d++) {
                int nr = teacher[0] + deltas[i][0] * d;
                int nc = teacher[1] + deltas[i][1] * d;

                if (!isIn(nr, nc) || hallway[nr][nc] == 'O') {
                    break;
                }

                if (hallway[nr][nc] == 'T')
                    continue;

                visited[nr][nc] = true;

                if (hallway[nr][nc] == 'S') {
                    found++;
                }
            }
        }

        return found;
    }

    public static boolean isIn(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

}