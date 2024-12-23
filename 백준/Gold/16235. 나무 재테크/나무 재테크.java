import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Tree implements Comparable<Tree> {
        int r, c, age;

        public Tree (int r, int c, int age) {
            this.r = r;
            this.c = c;
            this.age = age;
        }

        @Override
        public int compareTo(Tree t) {
            return this.age - t.age;
        }
    }

    public static int N;
    public static Deque<Tree> trees;
    public static int[][] A, nutrient;
    public static Queue<Tree> dead;
    public static int[][] deltas = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        nutrient = new int[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(nutrient[i], 5);
        }

        A = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        trees = new LinkedList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int age = Integer.parseInt(st.nextToken());

            trees.add(new Tree(r, c, age));
        }

        Collections.sort((List<Tree>) trees);

        dead = new ArrayDeque<>();

        for (int i = 0; i < K; i++) {
            spring();
            summer();
            fall();
            winter();
        }

        System.out.println(trees.size());
    }

    public static void spring () {
        int size = trees.size();

        for (int i = 0; i < size; i++) {
            Tree tree = trees.poll();

            if (nutrient[tree.r][tree.c] >= tree.age) {
                nutrient[tree.r][tree.c] -= tree.age;
                tree.age++;
                trees.add(tree);
            } else {
                dead.add(tree);
            }
        }
    }

    public static void summer () {
        while (!dead.isEmpty()) {
            Tree tree = dead.poll();

            nutrient[tree.r][tree.c] += tree.age / 2;
        }
    }

    public static void fall () {
        Queue<Tree> children = new ArrayDeque<>();

        for (Tree tree : trees) {
            if (tree.age % 5 == 0) {
                for (int d = 0; d < 8; d++) {
                    int nr = tree.r + deltas[d][0];
                    int nc = tree.c + deltas[d][1];

                    if (isIn(nr, nc)) {
                        children.offer(new Tree(nr, nc, 1));
                    }
                }
            }
        }

        while (!children.isEmpty()) {
            trees.addFirst(children.poll());
        }
    }

    public static void winter () {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                nutrient[i][j] += A[i][j];
            }
        }
    }

    public static boolean isIn (int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}