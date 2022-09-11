package LeetCodeContest.Weekly310;

import java.util.Arrays;

public class MostFrequentEven {
    public int mostFrequentEven(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        int max = 0;
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                dp[i] = i > 0 && nums[i] == nums[i - 1] ? dp[i - 1] + 1 : 1;
            }
            if (dp[i] > max) {
                max = dp[i];
                res = nums[i];
            }
        }
        return res;
    }
}
