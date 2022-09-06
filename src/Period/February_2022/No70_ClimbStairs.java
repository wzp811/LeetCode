package Period.February_2022;

public class No70_ClimbStairs {
    public int climbStairs1(int n){
        int[]dp = new int[n+1];
        for(int i=1;i<=n;i++){
            if(i<=2) dp[i] = i;
            else dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public int climbStairs(int n){
        int[]dp = new int[n+1];
        dp[0] = 1;
        for(int i=0;i<=n;i++){
             if(i>=1) dp[i] += dp[i-1];
             if(i>=2) dp[i] += dp[i-2];
        }
        return dp[n];
    }
}
