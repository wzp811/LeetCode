package Coding_Interviews_2th;

public class No63_MaxProfit {
    public int maxProfitDP(int[] prices){
        int[][] dp = new int[prices.length][2];
        for(int i=1;i<=prices.length;i++){
            dp[i][0] = Math.max(dp[i-1][0],-prices[i-1]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]+prices[i-1]);
        }
        return dp[prices.length][1];
    }

    public int maxProfit(int[] prices) {
        int min = prices[0];
        int ans = 0;
        for(int i=1;i<prices.length;i++){
            ans = Math.max(ans,prices[i]-min);
            min = Math.min(min,prices[i]);
        }
        return ans;
    }

}
