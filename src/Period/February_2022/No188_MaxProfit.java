package Period.February_2022;

public class No188_MaxProfit {
    public int maxProfit1(int k,int[] prices){
        if(k==0||prices.length==0) return 0;
        int[][] dp = new int[prices.length][k*2];
        for(int i=0;i<k;i++) dp[0][i*2] = -prices[0];
        for(int i=1;i<prices.length;i++){
            for(int j=0;j<k;j++){
                //不持有
                if(j==0) dp[i][j*2] = Math.max(dp[i-1][j*2],-prices[i]);
                else dp[i][j*2] = Math.max(dp[i-1][j*2],dp[i-1][j*2-1]-prices[i]);
                //持有
                dp[i][j*2+1] = Math.max(dp[i-1][j*2]+prices[i],dp[i-1][j*2+1]);
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<k;i++) max = Math.max(max,dp[prices.length-1][i*2+1]);
        return max;
    }
    public int maxProfit(int k,int[] prices){
        if(k==0||prices.length==0) return 0;
        int[] dp = new int[k*2];
        for(int i=0;i<k;i++) dp[2*i] = -prices[0];
        for(int i=1;i<prices.length;i++){
            for(int j=0;j<k;j++){
                if(j==0) dp[j*2] = Math.max(dp[j*2],-prices[i]);
                else dp[j*2] = Math.max(dp[j*2],dp[j*2-1]-prices[i]);
                dp[j*2+1] = Math.max(dp[j*2+1],dp[j*2]+prices[i]);
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<k;i++) max = Math.max(max,dp[2*i+1]);
        return max;
    }
    public static void main(String[] args) {
        No188_MaxProfit obj = new No188_MaxProfit();
        int[] prices = new int[]{3,2,6,5,0,3};
        System.out.println(obj.maxProfit(2,prices));
    }
}
