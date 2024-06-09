import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static class Node {
        char alpha;
        Node left;
        Node right;

        public Node (char alpha) {
            this.alpha = alpha;
            this.left = null;
            this.right = null;
        }
    }

    public static StringBuilder sb;
    public static Node[] tree;

    public static void main(String[] args) throws IOException {
        sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        tree = new Node[26];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            char parent = st.nextToken().charAt(0);

            if (tree[parent - 'A'] == null) {
                tree[parent - 'A'] = new Node(parent);
            }

            char left = st.nextToken().charAt(0);

            if (left != '.') {
                tree[left - 'A'] = new Node(left);
                tree[parent - 'A'].left = tree[left - 'A'];
            }

            char right = st.nextToken().charAt(0);

            if (right != '.') {
                tree[right - 'A'] = new Node(right);
                tree[parent - 'A'].right = tree[right - 'A'];
            }
        }

        preOrder(tree[0]);
        sb.append("\n");

        inOrder(tree[0]);
        sb.append("\n");

        postOrder(tree[0]);

        System.out.println(sb);
    }

    public static void preOrder(Node n) {
        if (n == null) {
            return;
        }

        sb.append(n.alpha);
        preOrder(n.left);
        preOrder(n.right);
    }

    public static void inOrder(Node n) {
        if (n == null) {
            return;
        }

        inOrder(n.left);
        sb.append(n.alpha);
        inOrder(n.right);
    }

    public static void postOrder(Node n) {
        if (n == null) {
            return;
        }

        postOrder(n.left);
        postOrder(n.right);
        sb.append(n.alpha);
    }
}