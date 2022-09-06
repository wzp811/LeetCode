package Y2022.Y2022_September;

import java.util.Arrays;

public class No494_FindTargetSumWays {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        int[] dp = new int[(sum + target) / 2 + 1];
        int tmp = (sum + target) / 2;
        for (int i = 0; i < nums.length; i++) {
            for (int j = tmp; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[tmp];
    }
}
