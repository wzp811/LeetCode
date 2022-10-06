package Y2022.Y2022_October;

public class No1800_MaxAscendingSum {
    public int maxAscendingSum(int[] nums) {
        int res = 0;
        int cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                cur += nums[i];
            } else {
                res = Math.max(res, cur);
                cur = nums[i];
            }
        }
        return Math.max(res, cur);
    }
}
