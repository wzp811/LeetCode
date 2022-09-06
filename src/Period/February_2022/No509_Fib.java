package Period.February_2022;

public class No509_Fib {
    public int fib(int n){
        int[] dp = new int[n+1];
        for(int i=0;i<=n;i++){
            if(i<2) dp[i] = i;
            else dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        No509_Fib obj = new No509_Fib();
        System.out.println(obj.fib(4));
    }
}
