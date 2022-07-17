package LeetCodeContest.Weekly302;

import java.util.*;

public class MaximumSum {
    public int maximumSum(int[] nums) {
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            int curPAT = getPAT(nums[i]);
            PriorityQueue<Integer> list = map.getOrDefault(curPAT, new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            }));
            if (map.containsKey(curPAT)) {
                res = Math.max(res, nums[i] + list.peek());
            }
            list.add(nums[i]);
            map.put(curPAT, list);
        }
        return res;
    }
    public int getPAT(int num) {
        int res = 0;
        while (num > 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }
}
