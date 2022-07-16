package CodeCapriccio;

import java.util.ArrayDeque;
import java.util.Deque;

public class No239_MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> dqe = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!dqe.isEmpty() && dqe.peekLast() < nums[i])
                dqe.pollLast();
            dqe.addLast(nums[i]);
            if (i >= k) {
                if (nums[i - k] == dqe.peekFirst())
                    dqe.pollFirst();
                res[i - k] = dqe.peekFirst();
            }
        }
        return res;
    }
}
