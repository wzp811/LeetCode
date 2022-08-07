package LeetCodeContest.Biweekly84;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TaskSchedulerII {
    public long taskSchedulerII1(int[] tasks, int space) {
        int[] expect = new int[tasks.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] next = new int[tasks.length];
        for (int i = tasks.length - 1; i >= 0; i--) {
            if (map.containsKey(tasks[i])) {
                next[i] = map.get(tasks[i]);
            }
            map.put(tasks[i], i);
        }
        int i = 0;
        int days = 1;
        while (i < tasks.length) {
            if (expect[i] <= days) {
                expect[next[i]] = days + space + 1;
                for (int j = i + 1; j < tasks.length; j++) {
                    if (tasks[j] == tasks[i]) {
                        expect[j] = days + space;
                        break;
                    }
                }
                i++;
            }
            days++;
        }
        return days - 1;
    }

    public long taskSchedulerII(int[] tasks, int space) {
        HashMap<Integer, Integer> map = new HashMap<>();
        long res = 0;
        for (int i = 0; i < tasks.length; i++) {
            int days = 0;
            if (map.containsKey(tasks[i])) {
                days = map.get(tasks[i]);
                Set<Integer> set = new HashSet<>(map.keySet());
                for (int index : set) {
                    if (index == tasks[i]) map.put(index, map.get(index) - days);
                    else map.put(index, map.get(index) - days -1);
                    if (map.get(index) <= 0) map.remove(index);
                }
            } else {
                Set<Integer> set = new HashSet<>(map.keySet());
                for (int index : set) {
                    map.put(index, map.get(index) - 1);
                    if (map.get(index) <= 0) map.remove(index);
                }
            }
            res += days;
            res++;
            map.put(tasks[i], space);
            System.out.println(res + " " + map);
        }
        return res;
    }
}
