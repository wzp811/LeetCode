package QuestionList.Coding_Interviews;

import java.util.PriorityQueue;

public class KthLargest {
    PriorityQueue<Integer> queue;
    int capacity;
    public KthLargest(int k, int[] nums) {
        queue = new PriorityQueue<>();
        capacity = k;
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }
        while (queue.size() > capacity) queue.poll();
    }

    public int add(int val) {
        queue.add(val);
        if (queue.size() > capacity) queue.poll();
        return queue.peek();
    }
}
