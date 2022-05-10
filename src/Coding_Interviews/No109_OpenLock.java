package Coding_Interviews;

import java.util.*;

public class No109_OpenLock {
    public int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>();
        for (String end : deadends) deads.add(end);
        if (deads.contains(target) || deads.contains("0000")) return -1;
        if (target.equals("0000")) return 0;
        Set<String> his = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        his.add("0000");
        int steps = 0;
        while (!queue.isEmpty()) {
            steps++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                List<String> nexts = next(cur);
                for (String next : nexts) {
                    if (!his.contains(next) && !deads.contains(next)) {
                        if (next.equals(target)) return steps;
                        queue.add(next);
                        his.add(next);
                    }
                }
            }
        }
        return -1;
    }

    public List<String> next(String str) {
        List<String> res = new LinkedList<>();
        char[] cur = str.toCharArray();
        char[] next = new char[4];
        for (int i = 0; i < 4; i++) next[i] = cur[i];
        for (int i = 0; i < 4; i++) {
            if (cur[i] == '9') next[i] = '0';
            else next[i]++;
            res.add(new String(next));
            if (cur[i] == '0') next[i] = '9';
            else next[i]--;
            res.add(new String(next));
            next[i] = cur[i];
        }
        return res;
    }

}
