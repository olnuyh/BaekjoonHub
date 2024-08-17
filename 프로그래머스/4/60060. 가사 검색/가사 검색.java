import java.util.*;

class Solution {
    public static class Node {
        Map<Integer, Integer> count = new HashMap();
        Map<Character, Node> children = new HashMap();
    }
    
    public static void insert (Node cur, String str) {
        for (int i = 0; i < str.length(); i++) {
            cur.count.put(str.length() - i, cur.count.getOrDefault(str.length() - i, 0) + 1);
            cur = cur.children.computeIfAbsent(str.charAt(i), key -> new Node());
        }
    }
    
    public static int search (Node cur, String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '?') {
                return cur.count.getOrDefault(str.length() - i, 0);
            }
            
            cur = cur.children.getOrDefault(str.charAt(i), null);
            
            if (cur == null) {
                return 0;
            }
        }
        
        return 1;
    }
    
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        
        Node trie = new Node();
        Node reversedTrie = new Node();
        
        for (String str : words) {
            insert(trie, str);
            insert(reversedTrie, new StringBuilder(str).reverse().toString());
        }
        
        for (int i = 0; i < queries.length; i++) {
            if (queries[i].startsWith("?")) {
                answer[i] = search(reversedTrie, new StringBuilder(queries[i]).reverse().toString());
            } else {
                answer[i] = search(trie, queries[i]);   
            }
        }
    
        return answer;
    }
}