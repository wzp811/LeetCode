package LeetCodeContest.Weekly307;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KSum {
    PriorityQueue<Long> queue = new PriorityQueue<>(((o1, o2) -> (int) (o2 - o1)));
    public long kSum(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            add(nums, (long)nums[i], i + 1);
        }
        queue.offer(0L);
        System.out.println(queue);
        for (int i = 0; i < k; i++) queue.poll();
        return queue.peek();
    }
    public void add(int[] nums, long sum, int index) {
        queue.offer(sum);
        if (index == nums.length) return;
        for (int i = index; i < nums.length; i++) {
            add(nums, (long)(sum + nums[i]), i + 1);
        }
    }
}
