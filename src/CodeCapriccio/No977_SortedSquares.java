package CodeCapriccio;

public class No977_SortedSquares {
    public int[] sortedSquares(int[] nums) {
        int left = -1, right = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                left = i;
            } else {
                right = i;
                break;
            }
        }
        int[] res = new int[nums.length];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (left == -1) {
                res[i] = nums[right] * nums[right];
                right++;
            } else if (right == nums.length) {
                res[i] = nums[left] * nums[left];
                left--;
            } else if (-nums[left] > nums[right]) {
                res[i] = nums[right] * nums[right];
                right++;
            } else {
                res[i] = nums[right] * nums[right];
                right++;
            }
        }
        return res;
    }
}
