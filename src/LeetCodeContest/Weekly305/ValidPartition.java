package LeetCodeContest.Weekly305;

import java.util.Arrays;

public class ValidPartition {
    public boolean validPartition(int[] nums) {
        boolean[] dp = new boolean[nums.length + 1];
        Arrays.fill(dp, false);
        dp[0] = true;
        dp[1] = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                dp[i + 1] = dp[i - 1] || (i >= 2 && nums[i] == nums[i - 2] && dp[i - 2]);
            } else {
                dp[i + 1] = (i >= 2 && nums[i] == nums[i - 1] + 1 && nums[i] == nums[i - 2] + 2) && dp[i - 2];
            }
        }
        return dp[nums.length];
    }
}
