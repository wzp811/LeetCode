package Coding_Interviews;

public class No8_MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int i = 0, j = 0;
        int ans = nums.length + 1;
        while (true) {
            if (sum >= target) {
                sum -= nums[i];
                i++;
            } else {
                if (j < nums.length) sum += nums[j++];
                else break;
            }
            if (sum >= target && ans > j - i) ans = j - i;
        }
        return ans == nums.length + 1 ? 0 : ans;
    }
}
