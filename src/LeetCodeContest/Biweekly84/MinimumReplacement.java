package LeetCodeContest.Biweekly84;

public class MinimumReplacement {
    public long minimumReplacement(int[] nums) {
        long cnt = 0;
        int last = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < last) {
                last = nums[i];
                continue;
            }
            int cur = nums[i] / last;
            if (nums[i] % last > 0) cur++;
            last = nums[i] / cur;
            cnt += cur - 1;
        }
        return cnt;
    }
}
