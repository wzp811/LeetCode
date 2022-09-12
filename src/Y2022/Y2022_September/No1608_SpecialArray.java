package Y2022.Y2022_September;

import java.util.Arrays;

public class No1608_SpecialArray {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] >= nums.length) return nums.length;
        for (int i = 1; i < nums.length; i++) {
            if (nums.length - i <= nums[i] && nums.length - i > nums[i - 1]) return nums.length - i;
        }
        return -1;
    }
}
