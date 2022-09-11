package LeetCodeContest.Weekly310;

import java.util.Arrays;

public class LengthOfLIS {
    public int lengthOfLIS1(int[] nums, int k) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i] && nums[j] + k >= nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    res = Math.max(res, dp[i]);
                }
            }
        }
        return res;
    }


    public int lengthOfLIS(int[] nums, int k) {
        int[] tails = new int[nums.length];
        int res = 1;
        for (int num : nums) {
            int i = 0, j = res;
            while (i < j) {
                int mid = i + ((j - i) >> 1);
                if (tails[mid] < num && tails[mid] + k >= num) {
                    i = mid + 1;
                } else {
                    j = mid;
                }
            }
            tails[i] = num;
            if (res == j) res++;
        }
        return res;
    }
}
