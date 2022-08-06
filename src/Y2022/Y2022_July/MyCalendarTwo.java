package Y2022.Y2022_July;

import java.util.ArrayList;
import java.util.List;

public class MyCalendarTwo {
    List<int[]> calendar;
    public MyCalendarTwo() {
        calendar = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        List<int[]> list = new ArrayList<>();
        for (int[] cur : calendar) {
            if (start >= cur[1] || end <= cur[0]) {
                continue;
            } else {
                int nstart = Math.max(start, cur[0]);
                int nend = Math.min(end, cur[1]);
                if (!book2(nstart, nend, list)) return false;
            }
        }
        calendar.add(new int[]{start, end});
        return true;
    }

    public boolean book2(int start, int end, List<int[]> list) {
        for (int[] cur : list) {
            if (start >= cur[1] || end <= cur[0]) continue;
            else return false;
        }
        list.add(new int[]{start, end});
        return true;
    }

}
