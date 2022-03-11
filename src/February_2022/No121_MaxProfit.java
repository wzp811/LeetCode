package February_2022;

public class No121_MaxProfit {
    public int maxProfit(int[] prices){
        int[][]dp = new int[prices.length][2];
        dp[0][0] -= prices[0];
        for(int i=1;i<prices.length;i++){
            dp[i][0] = Math.max(dp[i-1][0],-prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);
            for(int j=0;j<prices.length;j++) System.out.print(dp[j][0]+"\t");
            System.out.println();
            for(int j=0;j<prices.length;j++) System.out.print(dp[j][1]+"\t");
            System.out.println();
            System.out.println();
        }
        return dp[prices.length-1][1];
    }

    public static void main(String[] args) {
        No121_MaxProfit obj = new No121_MaxProfit();
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(obj.maxProfit(prices));
    }
}
