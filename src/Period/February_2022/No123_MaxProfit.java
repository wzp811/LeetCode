package Period.February_2022;

public class No123_MaxProfit {
    public int maxProfit(int[] prices){
        int[][]dp = new int[prices.length][4];
        dp[0][0] = -prices[0];
        dp[0][2] = -prices[0];
        for(int i=1;i<prices.length;i++){
            dp[i][0] = Math.max(dp[i-1][0],-prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);
            dp[i][2] = Math.max(dp[i-1][1]-prices[i],dp[i-1][2]);
            dp[i][3] = Math.max(dp[i-1][2]+prices[i],dp[i-1][3]);
        }
        return dp[prices.length-1][3];
    }

    public static void main(String[] args) {
        No123_MaxProfit obj = new No123_MaxProfit();
        int[] prices = new int[]{1};
        System.out.println(obj.maxProfit(prices));
    }
}
