package _Arrays;

public class No209_MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = nums[0];
        int left = 0, right = 0;
        int ans = nums.length + 1;
        while (right < nums.length || sum >= target) {
            System.out.println(left+" "+right+" : "+sum);
            if (sum >= target) {
                if (right - left + 1 < ans) ans = right - left + 1;
                sum -= nums[left++];
            } else if (sum < target) {
                if(right < nums.length - 1) sum += nums[++right];
                else break;
            }
        }
        return ans == nums.length + 1 ? 0 : ans;
    }

    public static void main(String[] args) {
        No209_MinSubArrayLen obj = new No209_MinSubArrayLen();
        int[] nums = new int[]{15,1,3,5,10,15,7,4,9,2,8};
        System.out.println(obj.minSubArrayLen(15,nums));
    }
}
