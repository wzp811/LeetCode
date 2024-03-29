package QuestionList.Coding_Interviews_2th;

public class No47_MaxValue {
    public int maxValue(int[][] grid){
        int[][] dp = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(i==0&&j==0) dp[i][j] = grid[i][j];
                else if(i==0) dp[i][j] = dp[i][j-1]+grid[i][j];
                else if(j==0) dp[i][j] = dp[i-1][j]+grid[i][j];
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[grid.length-1][grid[0].length];
    }
}
