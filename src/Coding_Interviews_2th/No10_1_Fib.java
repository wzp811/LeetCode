package Coding_Interviews_2th;

public class No10_1_Fib {
    public int fib(int n){
        int mod = 1000000007;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = (dp[i-1]+dp[i-2])%mod;
        }
        return dp[n];
    }
}
