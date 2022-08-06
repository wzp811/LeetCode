package Y2022.Y2022_July;

import java.util.ArrayList;
import java.util.List;

public class MyCalendar {

    List<int[]> queue;

    public MyCalendar() {
        queue = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] cur : queue) {
            if (!(cur[0] >= end || cur[1] <= start)) return false;
        }
        queue.add(new int[]{start, end});
        return true;
    }

}
