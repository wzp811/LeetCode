package CodeCapriccio;

public class No704_Search {
    // 左闭右闭
    public int search1(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) right = mid - 1;
            else if (nums[mid] < target) left = mid + 1;
        }
        return -1;
    }
    // 左闭右开
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length;
        int mid = 0;
        while (left < right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) right = mid;
            else if (nums[mid] < target) left = mid + 1;
        }
        return -1;
    }
}
