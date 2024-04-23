import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Student implements Comparable<Student> {
        int num, score1, score2;

        public Student(int num, int score1, int score2) {
            this.num = num;
            this.score1 = score1;
            this.score2 = score2;
        }

        @Override
        public int compareTo(Student o) {
            return this.score1 - o.score1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            Student[] students = new Student[N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                int score1 = Integer.parseInt(st.nextToken());
                int score2 = Integer.parseInt(st.nextToken());

                students[i] = new Student(i, score1, score2);
            }

            Arrays.sort(students);

            int score = students[0].score2;
            int count = 1;

            for (int i = 1; i < N; i++) {
                if (students[i].score2 < score) {
                    count++;
                    score = students[i].score2;
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}