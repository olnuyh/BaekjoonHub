import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Student implements Comparable<Student> {
        int num, post, recommend;

        public Student (int num, int post, int recommend) {
            this.num = num;
            this.post = post;
            this.recommend = recommend;
        }

        @Override
        public int compareTo(Student o) {
            if (this.recommend == o.recommend) {
                return this.post - o.post;
            }
            return this.recommend - o.recommend;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int M = Integer.parseInt(br.readLine());

        List<Student> pictures = new ArrayList<>();
        int[] recommends = new int[101];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= M; i++) {
            int candidate = Integer.parseInt(st.nextToken());

            if (recommends[candidate] > 0) {
                for (int j = 0; j < pictures.size(); j++) {
                    if (pictures.get(j).num == candidate) {
                        pictures.get(j).recommend++;
                        break;
                    }
                }
            } else {
                if (pictures.size() >= N) {
                    recommends[pictures.get(0).num] = 0;
                    pictures.remove(0);
                }

                pictures.add(new Student(candidate, i, 1));
                recommends[candidate] = 1;
            }

            Collections.sort(pictures);
        }

        for (int i = 1; i <= 100; i++) {
            if (recommends[i] > 0) {
                System.out.print(i + " ");
            }
        }
    }
}