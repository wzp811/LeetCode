package Coding_Inerviews_2th;

import java.util.Arrays;

public class No14_1_CuttingRope {
    public int cuttingRope(int n){
        int[] dp = new int[n+1];
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            for(int j=1;j<i;j++){
                dp[i] = Math.max(dp[i],Math.max(dp[i-j]*j,(i-j)*j));
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}
