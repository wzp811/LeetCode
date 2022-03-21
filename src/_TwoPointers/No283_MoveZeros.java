package _TwoPointers;

public class No283_MoveZeros {
    public void moveZeros(int[] nums) {
        int left = 0, right = 0;
        while (left < nums.length && right < nums.length) {
            while (left < nums.length && nums[left] != 0) left++;
            while (right < nums.length && nums[right] == 0) right++;
            if (left < right && left < nums.length && right < nums.length) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
            }
            right++;
        }
    }
}
