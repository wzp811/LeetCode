package Period.Hot100;

public class No152_MaxProduct {
    public int maxProduct1(int[] nums){
        int[][]dp = new int[nums.length][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        int max = nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i][0] = Math.max(Math.max(dp[i-1][0]*nums[i],dp[i-1][1]*nums[i]),nums[i]);
            dp[i][1] = Math.min(Math.min(dp[i-1][0]*nums[i],dp[i-1][1]*nums[i]),nums[i]);
            max = Math.max(max,dp[i][0]);
        }
        return max;
    }
    public int maxProduct(int[] nums){
        int max = nums[0];
        int maxF = nums[0];
        int minF = nums[0];
        for(int i=1;i<nums.length;i++){
            int tmp = maxF;
            maxF = Math.max(Math.max(maxF*nums[i],minF*nums[i]),nums[i]);
            minF = Math.min(Math.min(tmp*nums[i],minF*nums[i]),nums[i]);
            max = Math.max(maxF,max);
        }
        return max;
    }
}
