package LeetCodeContest.Biweekly85;

public class MaximumSegmentSum {
    public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
        long[] prex = new long[nums.length];
        prex[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prex[i] = prex[i - 1] + nums[i];
        }
        return prex;
    }
}
