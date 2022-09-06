package QuestionList.Coding_Interviews;

public class No102_FindTargetSumWays {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum < target || (sum - target) % 2 == 1) return 0;
        int negSum = (sum - target) / 2;
        int[][]dp = new int[nums.length + 1][negSum + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= negSum; j++) {
                if (j >= nums[i]) dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i]];
                else dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[nums.length][negSum];
    }
}
