package Examinations.YongYou;

import java.util.ArrayDeque;
import java.util.Deque;

public class Test3 {
    public int[] findBuilding (int[] heights) {
        // write code here
        Deque<Integer> stack = new ArrayDeque<>();
        int[] left = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            while (!(stack.isEmpty() || stack.peekLast() > heights[i])) {
                stack.pollLast();
            }
            left[i] = stack.size();
            stack.addLast(heights[i]);
        }
        stack.clear();
        int[] right = new int[heights.length];
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!(stack.isEmpty() || stack.peekLast() > heights[i])) {
                stack.pollLast();
            }
            right[i] = stack.size();
            stack.addLast(heights[i]);
        }
        int[] res = new int[heights.length];
        for (int i = 0; i < res.length; i++) {
            if (i > 0) res[i] += left[i - 1];
            if (i < res.length - 1) res[i] += right[i + 1];
            res[i]++;
        }
        return res;
    }
}
