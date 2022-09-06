package Period.February_2022;

public class No53_MaxSubArray {
    public int maxSubArray(int[] nums){
        int[]dp = new int[nums.length+1];
        int max = Integer.MIN_VALUE;
        for(int i=1;i<=nums.length;i++){
            dp[i] = Math.max(dp[i-1]+nums[i-1],dp[i]+nums[i-1]);
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        No53_MaxSubArray obj = new No53_MaxSubArray();
        int[] nums = new int[]{1};
        System.out.println(obj.maxSubArray(nums));
    }
}
