package QuestionList.Coding_Interviews;

public class No90_Rob {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        int[]dp0 = new int[n];
        dp0[0] = nums[0];
        dp0[1] = Math.max(nums[0], nums[1]);
        int[]dp1 = new int[n];
        dp1[0] = 0;
        dp1[1] = nums[1];
        dp1[2] = Math.max(nums[1], nums[2]);
        for (int i = 2; i < n - 1; i++) {
            dp0[i] = Math.max(dp0[i - 2] + nums[i], dp0[i - 1]);
        }
        for (int i = 3; i < n; i++) {
            dp1[i] = Math.max(dp1[i - 2] + nums[i], dp1[i - 1]);
        }
        return Math.max(Math.max(dp0[n - 3], dp0[n - 2]), Math.max(dp1[n - 1], dp1[n - 2]));
    }
}
