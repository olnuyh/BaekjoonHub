import java.util.*;

class Solution {
    public static ArrayList<String> list;
    public static String[] vowel = {"A", "E", "I", "O", "U"};
    
    public int solution(String word) {      
        list = new ArrayList();
        
        makeWords("");
        
        return list.indexOf(word) + 1;
    }
    
    public void makeWords(String cur) {
        if (cur.length() == 5) {
            return;
        }
        
        for (String v : vowel) {
            list.add(cur + v);
            makeWords(cur + v);
        }
    }
}