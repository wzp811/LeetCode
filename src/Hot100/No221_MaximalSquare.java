package Hot100;

public class No221_MaximalSquare {
    public int maximalSquare1(char[][] matrix){
        int[][] height = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='1') height[i][j] = i-1>=0?1:height[i-1][j]+1;
            }
        }
        int max = 0;
        int left,right;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                left = i;
                right = i;
                while(--left>=0&&height[left][j]>=height[i][j]);
                while(++right<matrix.length&&height[right][j]>=height[i][j]);
                max = Math.max(max,Math.min(right-left-1,height[i][j])*Math.min(right-left-1,height[i][j]));
            }
        }
        return max;
    }

    public int maximalSquare(char[][] matrix){
        int[][] dp = new int[matrix.length+1][matrix[0].length+1];
        int max = 0;
        for(int i=1;i<=matrix.length;i++){
            for(int j=1;j<=matrix[0].length;j++){
                if(matrix[i-1][j-1]=='1') dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                max = Math.max(max,dp[i][j]*dp[i][j]);
            }
        }
        return max;
    }
}
