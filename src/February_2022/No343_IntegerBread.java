package February_2022;

public class No343_IntegerBread {
    public int integerBreak(int n){
        int[]dp = new int[n+1];
        for(int i=1;i<=n;i++){
            if(i<3){
                dp[i] = 1;
                continue;
            }
            for(int j=i-1;j>1;j--){
                dp[i] = Math.max(dp[i],Math.max(dp[j]*(i-j),j*(i-j)));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        No343_IntegerBread obj = new No343_IntegerBread();
        System.out.println(obj.integerBreak(6));
    }
}
