package _Arrays;

public class No704_Search {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int mid = l + ((r - l) >> 1);
        while (l <= r) {
            mid = l + ((r - l) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            }
        }
        return -1;
    }
}
