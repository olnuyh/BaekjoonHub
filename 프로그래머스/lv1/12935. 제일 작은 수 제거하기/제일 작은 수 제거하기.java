import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        if(arr.length == 1)
            return new int[]{-1};
        int min = Arrays.stream(arr).min().getAsInt();
        ArrayList<Integer> A = new ArrayList();
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] == min)
                continue;
            A.add(arr[i]);
        }
        return A.stream().mapToInt(Integer::intValue).toArray();
    }
}