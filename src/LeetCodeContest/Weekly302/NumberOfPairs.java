package LeetCodeContest.Weekly302;

import java.util.HashSet;
import java.util.Set;

public class NumberOfPairs {
    public int[] numberOfPairs(int[] nums) {
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
                count++;
            } else {
                set.add(nums[i]);
            }
        }
        return new int[]{count, set.size()};
    }
}
