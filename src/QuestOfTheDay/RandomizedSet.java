package QuestOfTheDay;

import java.util.*;

public class RandomizedSet {
    HashMap<Integer, Integer> map;
    List<Integer> list;
    Random random;
    public RandomizedSet() {
        map = new HashMap<>();
        list = new LinkedList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        System.out.println(map);
        System.out.println(list);
        System.out.println();
        if (map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        System.out.println(map);
        System.out.println(list);
        System.out.println();
        if (!map.containsKey(val) || list.size() == 0) return false;
        int index = map.get(val);
        int last = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        list.set(index, last);
        map.put(last, index);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }
}
