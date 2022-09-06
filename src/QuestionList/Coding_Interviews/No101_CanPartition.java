package QuestionList.Coding_Interviews;

public class No101_CanPartition {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;
        int capacity = sum / 2;
        int[][] dp = new int[nums.length][capacity + 1];
        for (int i = 0; i < nums.length; i++) dp[i][0] = 0;
        for (int i = 0; i <= capacity; i++) if (i >= nums[0]) dp[0][i] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (j < nums[i]) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
            }
        }
        return dp[nums.length - 1][capacity] == capacity;
    }
}
