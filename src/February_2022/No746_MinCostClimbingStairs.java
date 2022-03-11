package February_2022;

public class No746_MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost){
        int len = cost.length;
        int[]dp = new int[len+1];
        for(int i=0;i<=len;i++){
            if(i<2) dp[i] = cost[i];
            else if(i==len) dp[i] = Math.min(dp[i-1],dp[i-2]);
            else dp[i] = cost[i]+Math.min(dp[i-1],dp[i-2]);
        }
        return dp[len];
    }

    public static void main(String[] args) {
        No746_MinCostClimbingStairs obj = new No746_MinCostClimbingStairs();
        int[] cost = new int[]{1,100,1,1,1,100,1,1,100,1};
        System.out.println(obj.minCostClimbingStairs(cost));
    }
}
