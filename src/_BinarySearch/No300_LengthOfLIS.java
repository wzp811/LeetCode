package _BinarySearch;

public class No300_LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int len = 1;
        int[] ans = new int[nums.length];
        ans[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > ans[len - 1]) {
                ans[len++] = nums[i];
            } else {
                int left = 0, right = len;
                int mid = 0;
                int pos = -1;
                while (left < right) {
                    mid = left + ((right - left) >> 1);
                    if (nums[i] > ans[mid]) {
                        left = mid + 1;
                        pos = mid;
                    } else {
                        right = mid;
                    }
                }
                ans[pos + 1] = nums[i];
            }
        }
        return len;
    }
}
