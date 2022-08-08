package Y2022.Y2022_August;

import LeetCodeContest.Weekly305.LongestIdealString;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class No636_ExclusiveTime {
    public int[] exclusiveTime1(int n, List<String> logs) {
        int[] res = new int[n];
        Deque<int[]> stack = new ArrayDeque<>();
        for (String log : logs) {
            String[] k = log.split(":");
            if (k[1].equals("start")) {
                int[] cur = new int[] {Integer.parseInt(k[0]), Integer.parseInt(k[2])};
                if (!stack.isEmpty()) {
                    int[] last = stack.peekLast();
                    res[last[0]] += cur[1] - last[1];
                }
                stack.addLast(cur);
            } else {
                int[] last = stack.pollLast();
                res[last[0]] += Integer.parseInt(k[2]) - last[1] + 1;
            }
        }
        return res;
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        int lastTime = 0;
        for (String log : logs) {
            String[] k = log.split(":");
            int curTime = Integer.parseInt(k[2]);
            int curFunc = Integer.parseInt(k[0]);
            if (k[1].equals("start")) {
                if (!stack.isEmpty()) {
                    res[stack.peekLast()] += curTime - lastTime;
                }
                stack.addLast(curFunc);
            } else {
                curTime++;
                res[curFunc] += curTime - lastTime;
                stack.pollLast();
            }
            lastTime = curTime;
        }
        return res;
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Class a = int.class;
        int t = (int) a.newInstance();
        System.out.println(t);
    }
}
