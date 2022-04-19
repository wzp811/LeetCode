package Coding_Interviews;

import java.util.ArrayList;
import java.util.List;

public class RecentCounter {
    int index = 0;
    List<Integer> list;
    public RecentCounter() {
        list = new ArrayList<>();
    }

    public int ping(int t) {
        list.add(t);
        while (list.get(index) < t - 3000) index++;
        return list.size() - index;
    }
}
