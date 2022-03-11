package February_2022;

public class No96_NumTrees {
    public int numTrees(int n){
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++) dp[i] += dp[j]*dp[i-j-1];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        No96_NumTrees obj = new No96_NumTrees();
        System.out.println(obj.numTrees(3));
    }
}
