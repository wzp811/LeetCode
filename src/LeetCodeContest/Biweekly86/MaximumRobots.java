package LeetCodeContest.Biweekly86;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumRobots {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int left = 0;
        while (left < chargeTimes.length && chargeTimes[left] + runningCosts[left] > budget) left++;
        if (left == chargeTimes.length) return 0;
        long cur = chargeTimes[left] + runningCosts[left];
        long sum = runningCosts[left];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(chargeTimes[left]);
        int right = left;
        int res = 1;
        while (right < chargeTimes.length) {
            while (!(stack.isEmpty() || stack.peekLast() >= chargeTimes[right])) {
                stack.pollLast();
            }
            stack.addLast(chargeTimes[right]);
            long next = stack.peekLast() + (sum + runningCosts[right]) * (right - left + 1);
            if (next <= budget) {
                res = Math.max(res, right - left + 1);
                sum += runningCosts[right];
                cur = next;
                right++;
            } else {
                if (chargeTimes[left] == stack.peekFirst()) stack.pollFirst();
                sum -= runningCosts[left];
                left++;
                cur = stack.peekLast() + sum * (right - left + 1);
            }
        }
        return res;
    }
}
