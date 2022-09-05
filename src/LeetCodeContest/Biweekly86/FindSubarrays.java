package LeetCodeContest.Biweekly86;

import java.util.HashSet;

public class FindSubarrays {
    public boolean findSubarrays(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i] + nums[i - 1];
            if (set.contains(cur)) return true;
            set.add(cur);
        }
        return false;
    }
}
