package QuestionList.Coding_Interviews;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class No61_KSmallestPairs {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1.length > nums1.length) return kSmallestPairs(nums2, nums1, k);
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return nums1[o2[0]] + nums2[o2[1]] - nums1[o1[0]] - nums2[o1[1]];
            }
        });
        for (int i = 0; i < nums1.length; i++) queue.add(new int[]{i, 0});
        for (int i = 0; i < Math.min(k, nums1.length * nums2.length); i++) {
            int[] nums = queue.poll();
            List<Integer> cur = new ArrayList<>();
            cur.add(nums1[nums[0]]);
            cur.add(nums2[nums[1]]);
            res.add(cur);
            queue.add(new int[]{nums[0], nums[1] + 1});
        }
        return res;
    }
}
