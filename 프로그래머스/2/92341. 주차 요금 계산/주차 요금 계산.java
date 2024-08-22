import java.util.*;

class Solution {
    class Car implements Comparable<Car>{
        int num;
        int price;
        
        public Car (int num, int price) {
            this.num = num;
            this.price = price;
        }
        
        public int compareTo(Car c) {
            return this.num - c.num;
        }
    }
    
    public int[] solution(int[] fees, String[] records) {
        HashMap<Integer, List<Integer>> hm = new HashMap();
        for (String str : records) {
            String[] record = str.split(" ");
            
            int num = Integer.parseInt(record[1]);
            String[] time = record[0].split(":");
            
            hm.putIfAbsent(num, new ArrayList());
            hm.get(num).add(Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]));
        }
        
        Car[] cars = new Car[hm.keySet().size()];
        int idx = 0;
        
        for (int num : hm.keySet()) {
            int sum = 0;
            
            List<Integer> list = hm.get(num);
            
            for (int i = 0; i < list.size() - 1; i += 2) {
                sum += list.get(i + 1) - list.get(i);
            }
            
            if (list.size() % 2 != 0) {
                sum += 23 * 60 + 59 - list.get(list.size() - 1);
            }
            
            int price = 0;
            if (sum <= fees[0]) {
                price = fees[1];
            } else {
                price = fees[1] + (int) Math.ceil((double)(sum - fees[0]) / fees[2]) * fees[3];
            }
            
            cars[idx++] = new Car(num, price);
        }
        
        Arrays.sort(cars);
        
        int[] answer = new int[cars.length];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = cars[i].price;
        }
        
        return answer;
    }
}