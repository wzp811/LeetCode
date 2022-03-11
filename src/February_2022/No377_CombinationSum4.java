package February_2022;

public class No377_CombinationSum4 {
    public int combinationSum4(int[] nums,int target){
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int i=0;i<=target;i++){
            for(int j=0;j<nums.length;j++) {
                if (i >= nums[j])
                    dp[i] += dp[i - nums[j]];
                System.out.print(dp[i]+" ");
            }
            System.out.println();
        }
        return dp[target];
    }
}
