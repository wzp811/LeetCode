package Y2022_July;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No1403_MinSubsequence {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int sum = Arrays.stream(nums).sum();
        Arrays.sort(nums);
        int cur = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            cur += nums[i];
            res.add(nums[i]);
            if (cur > sum - cur) return res;
        }
        return res;

    }
}
