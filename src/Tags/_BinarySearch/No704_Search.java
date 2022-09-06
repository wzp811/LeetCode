package Tags._BinarySearch;

public class No704_Search {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length;
        int mid = 0;
        while (left < right) {
            mid = left + ((right - left) >> 1);
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid;
            }
        }
        return -1;
    }
}
