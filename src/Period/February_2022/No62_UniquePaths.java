package Period.February_2022;

public class No62_UniquePaths {
    public int uniquePaths(int m,int n){
        int[][]dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0) dp[i][j] = 1;
                else if(j==0) dp[i][j] = 1;
                else dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        No62_UniquePaths obj = new No62_UniquePaths();
        System.out.println(obj.uniquePaths(3,3));
    }
}
