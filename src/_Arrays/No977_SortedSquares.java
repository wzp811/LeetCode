package _Arrays;

public class No977_SortedSquares {
    public int[] sortedSquares(int[] nums){
        int[] ans = new int[nums.length];
        int left = 0, right = nums.length-1;
        int index = nums.length-1;
        while(left<=right){
            if(Math.abs(nums[left])<Math.abs(nums[right])){
                ans[index--] = nums[right]*nums[right];
                right--;
            }else {
                ans[index--] = nums[left]*nums[left];
                left++;
            }
        }
        return ans;
    }
}
