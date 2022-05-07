package QuestOfTheDay;

import java.util.ArrayList;
import java.util.List;

public class RecentCounter {
    List<Integer> list = new ArrayList<>();
    int last = 0;
    public RecentCounter() {

    }

    public int ping(int t) {
        list.add(t);
        while (last < list.size() && list.get(last) + 3000 < t) {
            last++;
        }
        return list.size() - last;
    }
}
