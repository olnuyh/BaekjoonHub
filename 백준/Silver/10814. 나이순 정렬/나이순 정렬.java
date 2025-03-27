import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Member implements Comparable<Member> {
        int age;
        int order;
        String name;

        public Member (int age, int order, String name) {
            this.age = age;
            this.order = order;
            this.name = name;
        }

        public int compareTo (Member member) {
            if (this.age == member.age) {
                return this.order - member.order;
            }
            return this.age - member.age;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Member> memberList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            memberList.add(new Member(Integer.parseInt(st.nextToken()), i, st.nextToken()));
        }

        Collections.sort(memberList);

        StringBuilder sb = new StringBuilder();
        for (Member m : memberList) {
            sb.append(m.age).append(" ").append(m.name).append("\n");
        }

        System.out.println(sb);
    }
}
