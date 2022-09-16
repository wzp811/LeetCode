package Examinations.Midea;

import java.util.HashMap;
import java.util.HashSet;

public class Test1 {
    public boolean checkOrder1(int[] order) {
        // write code here
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < order.length; i++) {
            if (set.contains(order[i])) return false;
            set.add(order[i]);
        }
        return true;
    }

    public boolean checkOrder(int[] order) {
        // write code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length; i++) {
            int cnt = map.getOrDefault(order[i], 0);
            if (cnt == 2) return false;
            map.put(order[i], cnt + 1);
        }
        return true;
    }
}
