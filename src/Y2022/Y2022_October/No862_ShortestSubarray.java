package Y2022.Y2022_October;

import java.util.ArrayDeque;
import java.util.Deque;

public class No862_ShortestSubarray {
    public int shortestSubarray(int[] nums, int k) {
        long[] prev = new long[nums.length + 1];
        prev[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            prev[i] = prev[i - 1] + nums[i - 1];
        }
        // System.out.println(Arrays.toString(prev));
        Deque<Integer> queue = new ArrayDeque<>();
        int res = nums.length + 1;
        for (int i = 0; i <= nums.length; i++) {
            while (!queue.isEmpty() && prev[i] - prev[queue.peekFirst()] >= k) {
                res = Math.min(res, i - queue.pollFirst());
            }
            while (!queue.isEmpty() && prev[i] <= prev[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.addLast(i);
        }
        return res > nums.length ? -1 : res;
    }
}
