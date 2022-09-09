package Y2022.Y2022_September;

public class No213_Rob {
    public int rob(int[] nums) {
        if (nums.length < 2) return nums[0];
        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0];
        dp[1][0] = Math.max(nums[1], nums[0]);
        dp[0][1] = 0;
        dp[1][1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            if (i != nums.length - 1) dp[i][0] = Math.max(dp[i - 1][0], dp[i - 2][0] + nums[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][1] + nums[i]);
        }
        return Math.max(dp[nums.length - 1][0], dp[nums.length - 2][1]);
    }
}
