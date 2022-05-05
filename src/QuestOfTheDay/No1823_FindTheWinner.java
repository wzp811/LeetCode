package QuestOfTheDay;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No1823_FindTheWinner {
    public int findTheWinner(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) list.add(i);
        int cur = 1;
        while (list.size() > 1) {
            cur = (cur + k) % list.size();
            list.remove(cur);
        }
        return list.get(0);
    }
}
