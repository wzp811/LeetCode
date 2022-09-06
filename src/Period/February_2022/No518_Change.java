package Period.February_2022;

public class No518_Change {
    public int change(int amount,int[] coins){
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int i=0;i<coins.length;i++){
            for(int j=coins[i];j<=amount;j++) dp[j] = Math.max(dp[j],dp[j-coins[i]]+dp[j]);
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        No518_Change obj = new No518_Change();
        int[] coins = new int[]{2};
        System.out.println(obj.change(3,coins));
    }
}
