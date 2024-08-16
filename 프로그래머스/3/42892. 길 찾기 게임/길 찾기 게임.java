import java.util.*;

class Solution {
    public static List<Integer> preNodes;
    public static List<Integer> postNodes;
    
    public static class Node implements Comparable<Node>{
        int num, x, y;
        Node left, right;
        
        public Node (int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
        
        public int compareTo (Node node) {
            return node.y - this.y;
        }
    }
    
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];
        
        Node[] nodes = new Node[nodeinfo.length];
        
        for (int i = 0; i < nodeinfo.length; i++) {
            int[] node = nodeinfo[i];
            
            nodes[i] = new Node(i + 1, node[0], node[1]);
        }
        
        Arrays.sort(nodes);
        
        Node root = makeTree(nodes);
        
        preNodes = new ArrayList();
        postNodes = new ArrayList();
        
        pre(root);
        post(root);
        
        for (int i = 0; i < nodeinfo.length; i++) {
            answer[0][i] = preNodes.get(i);
            answer[1][i] = postNodes.get(i);
        }
        
        return answer;
    }
    
    public Node makeTree(Node[] nodes) {
        Node root = nodes[0];
    
        for (int i = 1; i < nodes.length; i++) {
            insert(root, nodes[i]);
        }
        
        return root;
    }
    
    public void insert(Node root, Node cur) {
        if (cur.x < root.x) {
            if (root.left == null) {
                root.left = cur;
            } else {
                insert(root.left, cur);
            }
        } else {
            if (root.right == null) {
                root.right = cur;
            } else {
                insert(root.right, cur);
            }
        }
    }
    
    public void pre(Node node) {
        if (node == null) {
            return;
        }
        
        preNodes.add(node.num);
        pre(node.left);
        pre(node.right);
    }
    
    public void post(Node node) {
        if (node == null) {
            return;
        }
        
        post(node.left);
        post(node.right);
        postNodes.add(node.num);
    }
}