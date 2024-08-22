import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> map = new TreeMap();
        
        for (String str : records) {
            String[] record = str.split(" ");
            
            String[] time = record[0].split(":");
            int second = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            boolean isIn = record[2].equals("IN");
            
            if(isIn) {
                second *= -1;
            }
            
            map.put(record[1], map.getOrDefault(record[1], 0) + second);
        }
        
        int[] answer = new int[map.size()];
        
        int idx = 0;
        
        for (String num : map.keySet()) {
            int time = map.get(num);
            
            if (time < 1) {
                time += 23 * 60 + 59;
            }
            
            int price = fees[1];
            time -= fees[0];
            
            while (time > 0) {
                price += fees[3];
                time -= fees[2];
            }
            
            answer[idx++] = price;
        }
        
//         Car[] cars = new Car[hm.keySet().size()];
//         int idx = 0;
        
//         for (int num : hm.keySet()) {
//             int sum = 0;
            
//             List<Integer> list = hm.get(num);
            
//             for (int i = 0; i < list.size() - 1; i += 2) {
//                 sum += list.get(i + 1) - list.get(i);
//             }
            
//             if (list.size() % 2 != 0) {
//                 sum += 23 * 60 + 59 - list.get(list.size() - 1);
//             }
            
//             int price = 0;
//             if (sum <= fees[0]) {
//                 price = fees[1];
//             } else {
//                 price = fees[1] + (int) Math.ceil((double)(sum - fees[0]) / fees[2]) * fees[3];
//             }
            
//             cars[idx++] = new Car(num, price);
//         }
        
//         Arrays.sort(cars);
        
//         for (int i = 0; i < answer.length; i++) {
//             answer[i] = cars[i].price;
//         }
        
        return answer;
    }
}