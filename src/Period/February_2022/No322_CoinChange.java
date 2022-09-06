package Period.February_2022;

import java.util.Arrays;

public class No322_CoinChange {
    public int coinChange(int[] coins,int amount){
        if(amount==0) return 0;
        int[]dp = new int[amount+1];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        for(int i=0;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                if(i>=coins[j]&&dp[i-coins[j]]!=-1) dp[i] = Math.min(dp[i-coins[j]]+1,dp[i]==-1?Integer.MAX_VALUE:dp[i]);
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        No322_CoinChange obj = new No322_CoinChange();
        int[] coins = new int[]{1,2,5};
//        int[] coins = new int[]{1};
        System.out.println(obj.coinChange(coins,11));
    }
}
