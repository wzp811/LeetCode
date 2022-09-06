package Period.February_2022;

public class No309_MaxProfit {
    public int maxProfit1(int[] prices){
        int[][] dp = new int[prices.length][prices.length];
        int max = 0;
        for(int i=0;i<prices.length/2;i++) dp[0][i*2] = -prices[0];
        for(int i=1;i<prices.length;i++){
            for(int j=0;j<prices.length/2;j++){
                if(j==0||i<2) dp[i][2*j] = Math.max(dp[i-1][2*j],-prices[i]);
                else dp[i][2*j] = Math.max(dp[i-1][2*j],dp[i-2][2*j-1]-prices[i]);
                dp[i][2*j+1] = Math.max(dp[i-1][2*j+1],dp[i-1][2*j]+prices[i]);
                max = Math.max(max,dp[i][2*j+1]);
            }
        }
        return max;
    }
    public int maxProfit2(int[] prices){
        int[][]dp = new int[prices.length][4];
        dp[0][0] = -prices[0];
        for(int i=1;i<prices.length;i++){
            dp[i][0] = Math.max(dp[i-1][0],Math.max(dp[i-1][3],dp[i-1][2])-prices[i]);
            dp[i][1] = dp[i-1][0]+prices[i];
            dp[i][2] = dp[i-1][1];
            dp[i][3] = Math.max(dp[i-1][2],dp[i-1][3]);
        }
        int len = prices.length;
        return Math.max(dp[len-1][1],Math.max(dp[len-1][2],dp[len-1][3]));
    }

    public int maxProfit(int[] prices){
        int[]dp = new int[4];
        dp[0] = -prices[0];
        for(int i=1;i<prices.length;i++){
            int tmp = dp[0];
            dp[0] = Math.max(dp[0],Math.max(dp[3],dp[2])-prices[i]);
            dp[3] = Math.max(dp[2],dp[3]);
            dp[2] = dp[1];
            dp[1] = tmp+prices[i];
        }
        return Math.max(dp[1],Math.max(dp[2],dp[3]));
    }

    public static void main(String[] args) {
        No309_MaxProfit obj = new No309_MaxProfit();
        int[] prices = new int[]{1};
        System.out.println(obj.maxProfit(prices));
    }
}
