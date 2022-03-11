package February_2022;

public class No122_MaxProfit {
    public int maxProfit(int[] prices){
        int[][]dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        for(int i=1;i<prices.length;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);
        }
        return dp[prices.length-1][1];
    }

    public static void main(String[] args) {
        No122_MaxProfit obj = new No122_MaxProfit();
        int[] prices = new int[]{7,6,4,3,1};
        System.out.println(obj.maxProfit(prices));

    }
}
