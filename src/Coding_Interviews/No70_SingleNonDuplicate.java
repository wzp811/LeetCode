package Coding_Interviews;

public class No70_SingleNonDuplicate {
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        int mid = 0;
        int res = 0;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] == nums[mid ^ 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[mid];
    }
}
