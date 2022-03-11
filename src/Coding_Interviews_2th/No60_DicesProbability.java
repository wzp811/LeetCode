package Coding_Interviews_2th;

import java.util.Arrays;

public class No60_DicesProbability {
    public double[] dicesProbability(int n){
        double[] dp = new double[n*6+1];
        dp[0] = 1;
        for(int i=1;i<=n;i++){
            for(int j=i*6;j>=i;j--){
                dp[j] = 0;
                for(int k=1;k<=6;k++) {
                    if(j - k >= (i - 1) && j - k <= (i - 1) * 6) {
                        dp[j] += dp[j - k] * ((double) 1 / 6);
                    }
                }
            }
            System.out.println(Arrays.toString(dp));
        }
        double[] ans = new double[n*6-n+1];
        for(int i=n;i<=n*6;i++) ans[i-n] = dp[i];
        return ans;
    }

    public static void main(String[] args) {
        No60_DicesProbability obj = new No60_DicesProbability();
        obj.dicesProbability(4);
    }
}
