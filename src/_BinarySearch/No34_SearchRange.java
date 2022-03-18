package _BinarySearch;

public class No34_SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int ans1 = search(nums, target);
        int ans2 = search(nums, target + 1);
        if (nums.length == 0 || nums[ans1] != target) return new int[]{-1, -1};
        return new int[]{ans1, nums[ans2] == target ? ans2 : ans2 - 1};
    }

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid = left;
        int ans = right;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            }
        }
        return ans;
    }
}
