package Y2022.Y2022_September;

public class No377_CombinationSum4 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] <= i)
                    dp[j] += dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}
