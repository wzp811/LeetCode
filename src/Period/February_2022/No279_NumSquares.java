package Period.February_2022;

public class No279_NumSquares {
    public int numSquares(int n){
        int[]dp = new int[n+1];
        for(int i=0;i<=n;i++) dp[i] = i;
        int biggest = (int)Math.sqrt(n);
        for(int i=1;i<=biggest;i++){
            for(int j=i*i;j<=n;j++){
                dp[j] = Math.min(dp[j],dp[j-i*i]+1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        No279_NumSquares obj = new No279_NumSquares();
        System.out.println(obj.numSquares(12));
    }
}
