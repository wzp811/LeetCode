package QuestionList.Coding_Interviews;

import java.util.TreeMap;

public class MyCalendar {
    TreeMap<Integer, Integer> calendar;
    public MyCalendar() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer prev = calendar.floorKey(start), next = calendar.ceilingKey(start);
        if ((prev == null || calendar.get(prev) <= start) && (next == null || next >= end)) {
            calendar.put(start, end);
            return true;
        }
        return false;
    }
}
