package Y2022.Y2022_October;

import java.util.Arrays;

public class No915_PartitionDisjoint {
    public int partitionDisjoint(int[] nums) {
        int[] rightMin = new int[nums.length];
        int min = nums[nums.length - 1];
        for (int i = nums.length - 1; i >= 0; i--) {
            min = Math.min(nums[i], min);
            rightMin[i] = min;
        }
        System.out.println(Arrays.toString(rightMin));
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (max <= rightMin[i]) return i;
            max = Math.max(nums[i], max);
        }
        return nums.length;
    }
}
