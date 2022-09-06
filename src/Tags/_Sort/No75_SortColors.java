package Tags._Sort;

public class No75_SortColors {
    public void sortColors(int[] nums) {
        int left = -1;
        int right = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                swap(nums, i, left++);
            } else if (nums[i] == 2) {
                swap(nums, i--, right--);
            }
        }
    }

    public void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
